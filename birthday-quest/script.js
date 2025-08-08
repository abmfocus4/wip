/* Birthday Quest: Pick Your Perfect Day
   Vanilla JS game with stages, scoring, mood, fun facts, final reveal, replay, and share.
*/

// ---------- Data ----------
const stages = [
  {
    id: 'dinner',
    title: 'Stage 1 — Dinner',
    desc: 'Pick tonight\'s dinner vibe.',
    options: [
      {
        id: 'trattoria',
        icon: '🍝',
        title: 'Cozy Trattoria',
        desc: 'Homemade pasta, candlelight, soft jazz.',
        tags: ['casual', 'romantic'],
        base: 12,
      },
      {
        id: 'sushi',
        icon: '🍣',
        title: 'Sushi Star',
        desc: 'Omakase elegance with sparkling mocktails.',
        tags: ['classy', 'refined'],
        base: 14,
      },
      {
        id: 'tacos',
        icon: '🌮',
        title: 'Taco Truck Fiesta',
        desc: 'Street tacos, neon lights, and laughter.',
        tags: ['playful', 'casual'],
        base: 11,
      },
    ],
  },
  {
    id: 'outfit',
    title: 'Stage 2 — Outfit',
    desc: 'Dress the part!',
    options: [
      {
        id: 'casual-chic',
        icon: '👟',
        title: 'Casual Chic',
        desc: 'Sneakers, denim, cozy sweater.',
        tags: ['casual'],
        base: 10,
      },
      {
        id: 'date-night',
        icon: '👗',
        title: 'Date Night',
        desc: 'Dressy with a touch of sparkle.',
        tags: ['classy', 'refined'],
        base: 13,
      },
      {
        id: 'quirky-fun',
        icon: '🧢',
        title: 'Quirky Fun',
        desc: 'Bold colors and playful accessories.',
        tags: ['playful'],
        base: 11,
      },
    ],
  },
  {
    id: 'bar',
    title: 'Stage 3 — Bar',
    desc: 'After-dinner hangout.',
    options: [
      {
        id: 'speakeasy',
        icon: '🍸',
        title: 'Hidden Speakeasy',
        desc: 'Dim lights, velvet seats, smooth tunes.',
        tags: ['classy', 'romantic'],
        base: 13,
      },
      {
        id: 'rooftop',
        icon: '🌆',
        title: 'Skyline Rooftop',
        desc: 'Open air, city lights, clinking glasses.',
        tags: ['refined'],
        base: 12,
      },
      {
        id: 'arcade',
        icon: '🕹️',
        title: 'Retro Arcade Bar',
        desc: 'Games, neon, and high scores.',
        tags: ['playful', 'casual'],
        base: 11,
      },
    ],
  },
  {
    id: 'cake',
    title: 'Stage 4 — Cake',
    desc: 'Choose the sweet finale.',
    options: [
      {
        id: 'choc-ganache',
        icon: '🍫',
        title: 'Chocolate Ganache',
        desc: 'Rich, glossy, decadent.',
        tags: ['classy'],
        base: 12,
      },
      {
        id: 'funfetti',
        icon: '🎂',
        title: 'Funfetti',
        desc: 'Sprinkles, smiles, instant party.',
        tags: ['playful'],
        base: 11,
      },
      {
        id: 'tiramisu',
        icon: '☕',
        title: 'Tiramisu',
        desc: 'Coffee-kissed classic.',
        tags: ['refined', 'classy'],
        base: 13,
      },
    ],
  },
];

const funFacts = [
  'The word “birthday” first appeared in English in the 1570s.',
  'In some cultures, long noodles symbolize long life—slurp for luck!',
  'Vanilla is the most popular cake flavor worldwide.',
  'Tacos became popular in the U.S. in the early 1900s—party staple since!',
  'Rooftop bars took off in the 2010s—cheers to sky-high vibes!'
];

// synergy rules add bonus points for matching vibes across stage pairs
const synergyRules = [
  { a: 'dinner', b: 'outfit', tag: 'casual', bonus: 3 },
  { a: 'dinner', b: 'outfit', tag: 'classy', bonus: 3 },
  { a: 'dinner', b: 'bar', tag: 'playful', bonus: 2 },
  { a: 'outfit', b: 'bar', tag: 'classy', bonus: 2 },
  { a: 'bar', b: 'cake', tag: 'refined', bonus: 2 },
  { a: 'dinner', b: 'cake', tag: 'romantic', bonus: 2 },
];

// ---------- State ----------
const state = {
  index: 0,
  choicesByStage: {}, // { stageId: optionId }
  points: 0,
  mood: 0,
};

// ---------- DOM ----------
const elStageTitle = document.getElementById('stage-title');
const elStageDesc = document.getElementById('stage-desc');
const elOptions = document.getElementById('options');
const elBtnNext = document.getElementById('btn-next');
const elBtnBack = document.getElementById('btn-back');
const elProgressText = document.getElementById('progress-text');
const elProgressFill = document.getElementById('progress-bar-fill');
const elMoodFill = document.getElementById('mood-bar-fill');
const elMoodValue = document.getElementById('mood-value');
const elToast = document.getElementById('toast');
const elFinal = document.getElementById('final');
const elFinalSummary = document.getElementById('final-summary');
const elFinalMoodFill = document.getElementById('final-mood-fill');
const elFinalScore = document.getElementById('final-score');
const elBtnReplay = document.getElementById('btn-replay');
const elBtnEdit = document.getElementById('btn-edit');
const elBtnStats = document.getElementById('btn-stats');
const elStatsDialog = document.getElementById('stats-dialog');
const elStatsContent = document.getElementById('stats-content');
const elBtnShare = document.getElementById('btn-share');

// ---------- Utils ----------
function clamp(min, value, max) { return Math.max(min, Math.min(value, max)); }
function sample(arr) { return arr[Math.floor(Math.random() * arr.length)]; }
function getStageById(id) { return stages.find(s => s.id === id); }
function getOption(stageId, optionId) {
  const st = getStageById(stageId);
  return st?.options.find(o => o.id === optionId);
}
function encodePlan(choices) {
  try {
    const data = btoa(unescape(encodeURIComponent(JSON.stringify(choices))));
    return data;
  } catch (_) { return ''; }
}
function decodePlan(encoded) {
  try {
    return JSON.parse(decodeURIComponent(escape(atob(encoded))));
  } catch (_) { return null; }
}

// ---------- Scoring Helpers (order-aware) ----------
function getStageIndexById(stageId) {
  return stages.findIndex(s => s.id === stageId);
}

function computeSynergyBonusAgainstPrevious(stageIndex, choicesByStage, recordCombosForStageId = null) {
  // Only compare current stage against strictly previous stages to avoid double counting
  const currentStage = stages[stageIndex];
  if (!currentStage) return 0;
  const currentOptionId = choicesByStage[currentStage.id];
  if (!currentOptionId) return 0;
  const current = getOption(currentStage.id, currentOptionId);
  if (!current) return 0;

  let bonus = 0;
  for (let i = 0; i < stageIndex; i += 1) {
    const prevStage = stages[i];
    const prevOptionId = choicesByStage[prevStage.id];
    if (!prevOptionId) continue;
    const prev = getOption(prevStage.id, prevOptionId);
    if (!prev) continue;

    // general tag overlap bonus
    const shared = current.tags.filter(t => prev.tags.includes(t));
    bonus += shared.length * 1; // +1 per shared vibe

    // rule-based bonus (unordered pair, but we only count in one direction due to previous-only)
    for (const rule of synergyRules) {
      const isPair = (rule.a === prevStage.id && rule.b === currentStage.id) || (rule.b === prevStage.id && rule.a === currentStage.id);
      if (isPair) {
        if (current.tags.includes(rule.tag) && prev.tags.includes(rule.tag)) {
          bonus += rule.bonus;
          if (recordCombosForStageId === currentStage.id) {
            recordCombo(prevStage.id, prevOptionId, currentStage.id, currentOptionId, rule.bonus);
          }
        }
      }
    }
  }
  return bonus;
}

function computeTotalPoints(choicesByStage) {
  let total = 0;
  for (let i = 0; i < stages.length; i += 1) {
    const st = stages[i];
    const optId = choicesByStage[st.id];
    if (!optId) continue;
    const opt = getOption(st.id, optId);
    if (!opt) continue;
    total += opt.base + computeSynergyBonusAgainstPrevious(i, choicesByStage, null);
  }
  return total;
}

// ---------- Rankings (localStorage) ----------
const STORAGE_KEY = 'birthday-quest-stats-v1';
function loadStats() {
  try { return JSON.parse(localStorage.getItem(STORAGE_KEY)) || { options: {}, combos: {}, plays: 0 }; }
  catch { return { options: {}, combos: {}, plays: 0 }; }
}
function saveStats(stats) { localStorage.setItem(STORAGE_KEY, JSON.stringify(stats)); }

function recordSelection(stageId, optionId, pointsAwarded) {
  const stats = loadStats();
  stats.options[optionId] = stats.options[optionId] || { count: 0, points: 0 };
  stats.options[optionId].count += 1;
  stats.options[optionId].points += pointsAwarded;
  saveStats(stats);
}

function recordCombo(stageA, optionA, stageB, optionB, bonus) {
  const key = `${stageA}:${optionA}|${stageB}:${optionB}`;
  const stats = loadStats();
  stats.combos[key] = stats.combos[key] || { count: 0, bonus: 0 };
  stats.combos[key].count += 1;
  stats.combos[key].bonus += bonus;
  saveStats(stats);
}

function recordPlayComplete() {
  const stats = loadStats();
  stats.plays += 1;
  saveStats(stats);
}

function renderStats() {
  const stats = loadStats();

  const optionRows = Object.entries(stats.options)
    .sort((a,b) => b[1].count - a[1].count)
    .slice(0, 8)
    .map(([optionId, info]) => {
      const option = findOptionById(optionId);
      if (!option) return '';
      return `<div class="stats-row"><span class="left"><span class="icon">${option.icon}</span> ${option.title}</span><span>${info.count}× · ${info.points} pts</span></div>`;
    }).join('');

  const comboRows = Object.entries(stats.combos)
    .sort((a,b) => b[1].bonus - a[1].bonus)
    .slice(0, 6)
    .map(([key, info]) => {
      const [a, b] = key.split('|');
      const [stageA, optA] = a.split(':');
      const [stageB, optB] = b.split(':');
      const oA = getOption(stageA, optA);
      const oB = getOption(stageB, optB);
      if (!oA || !oB) return '';
      return `<div class="stats-row"><span class="left"><span class="icon">${oA.icon}</span> ${oA.title} → <span class="icon">${oB.icon}</span> ${oB.title}</span><span>+${info.bonus} bonus · ${info.count}×</span></div>`;
    }).join('');

  elStatsContent.innerHTML = `
    <section class="stats-section">
      <h4>Most Picked</h4>
      <div class="stats-list">${optionRows || '<em>No data yet—go play!</em>'}</div>
    </section>
    <section class="stats-section">
      <h4>Sparkling Combos</h4>
      <div class="stats-list">${comboRows || '<em>Combos show up after a few plays.</em>'}</div>
    </section>
    <section class="stats-section">
      <h4>Play Count</h4>
      <div>${stats.plays}</div>
    </section>
  `;
}

function findOptionById(optionId) {
  for (const st of stages) {
    const opt = st.options.find(o => o.id === optionId);
    if (opt) return opt;
  }
  return null;
}

// ---------- Rendering ----------
function renderStage() {
  const stage = stages[state.index];
  if (!stage) return;

  elFinal.classList.add('hidden');

  elStageTitle.textContent = stage.title;
  elStageDesc.textContent = stage.desc;
  elOptions.innerHTML = '';

  const selectedOptionId = state.choicesByStage[stage.id];

  for (const option of stage.options) {
    const card = document.createElement('div');
    card.className = 'card' + (selectedOptionId === option.id ? ' selected' : '');
    card.tabIndex = 0;
    card.setAttribute('role', 'button');
    card.setAttribute('aria-pressed', selectedOptionId === option.id ? 'true' : 'false');

    const hero = document.createElement('div');
    hero.className = 'card-hero';
    hero.textContent = option.icon;

    const title = document.createElement('div');
    title.className = 'card-title';
    title.textContent = option.title;

    const desc = document.createElement('p');
    desc.className = 'card-desc';
    desc.textContent = option.desc;

    const tags = document.createElement('div');
    tags.className = 'card-tags';
    for (const t of option.tags) {
      const tag = document.createElement('span');
      tag.className = 'tag';
      tag.textContent = t;
      tags.appendChild(tag);
    }

    card.appendChild(hero);
    card.appendChild(title);
    card.appendChild(desc);
    card.appendChild(tags);

    card.addEventListener('click', () => selectOption(stage.id, option.id));
    card.addEventListener('keydown', (e) => { if (e.key === 'Enter' || e.key === ' ') { e.preventDefault(); selectOption(stage.id, option.id); } });

    elOptions.appendChild(card);
  }

  elBtnBack.disabled = state.index === 0;
  elBtnNext.disabled = !selectedOptionId;

  const total = stages.length;
  elProgressText.textContent = `Stage ${state.index + 1} / ${total}`;
  elProgressFill.style.width = `${((state.index) / total) * 100}%`;
}

function showToast(message) {
  elToast.textContent = message;
  elToast.classList.add('show');
  setTimeout(() => elToast.classList.remove('show'), 2000);
}

function updateMood() {
  // normalize: assume max raw points ~ 60; scale to %
  const percent = clamp(0, Math.round((state.points / 60) * 100), 100);
  state.mood = percent;
  elMoodFill.style.width = `${percent}%`;
  elMoodValue.textContent = `${percent}%`;
}

function computeSynergyBonus(stageId, optionId) {
  let bonus = 0;
  const current = getOption(stageId, optionId);
  if (!current) return 0;

  // Adjusted: only count against previous stages to avoid double-counting
  const currentIndex = getStageIndexById(stageId);
  const tempChoices = { ...state.choicesByStage, [stageId]: optionId };
  bonus = computeSynergyBonusAgainstPrevious(currentIndex, tempChoices, null);
  return bonus;
}

function selectOption(stageId, optionId) {
  const stage = getStageById(stageId);
  const option = getOption(stageId, optionId);
  if (!stage || !option) return;

  const stageIndex = getStageIndexById(stageId);
  const tempChoices = { ...state.choicesByStage, [stageId]: optionId };
  const synergy = computeSynergyBonusAgainstPrevious(stageIndex, tempChoices, stageId);
  const awarded = option.base + synergy;

  state.choicesByStage[stageId] = optionId;
  state.points = computeTotalPoints(state.choicesByStage);
  recordSelection(stageId, optionId, awarded);

  renderStage();
  updateMood();

  showToast(`+${awarded} pts · ${sample(funFacts)}`);

  elBtnNext.disabled = false;
}

function toFinal() {
  elFinal.classList.remove('hidden');

  // Build summary
  const items = [];
  for (const stage of stages) {
    const opt = getOption(stage.id, state.choicesByStage[stage.id]);
    if (!opt) continue;
    items.push({ stage, opt });
  }

  const summaryHtml = items.map(({ stage, opt }) => `
    <div class="final-item">
      <span class="icon">${opt.icon}</span>
      <div>
        <div class="title">${stage.title.replace(/Stage \d+ — /, '')}: ${opt.title}</div>
        <div class="desc">${opt.desc}</div>
      </div>
    </div>
  `).join('');

  elFinalSummary.innerHTML = summaryHtml;
  elFinalScore.textContent = String(state.points);
  elFinalMoodFill.style.width = `${state.mood}%`;

  recordPlayComplete();
  renderStats();
}

function nextStage() {
  if (state.index < stages.length - 1) {
    state.index += 1;
    renderStage();
  } else {
    // final
    elProgressFill.style.width = '100%';
    toFinal();
  }
}

function prevStage() {
  if (state.index > 0) {
    state.index -= 1;
    renderStage();
  }
}

function resetGame() {
  state.index = 0;
  state.choicesByStage = {};
  state.points = 0;
  state.mood = 0;
  elFinal.classList.add('hidden');
  updateMood();
  renderStage();
}

function editChoices() {
  // Go to stage list with existing selections
  state.index = 0;
  renderStage();
}

// ---------- Share ----------
function copyShareLink() {
  const plan = encodePlan(state.choicesByStage);
  const url = new URL(window.location.href);
  url.searchParams.set('plan', plan);
  navigator.clipboard.writeText(url.toString()).then(() => {
    showToast('Link copied to clipboard!');
  }).catch(() => showToast('Unable to copy link.'));
}

function tryLoadPlanFromUrl() {
  const url = new URL(window.location.href);
  const plan = url.searchParams.get('plan');
  if (!plan) return false;
  const choices = decodePlan(plan);
  if (!choices) return false;

  // preload selections
  state.choicesByStage = choices;
  // compute points and mood deterministically (no combo recording here)
  state.points = computeTotalPoints(state.choicesByStage);
  updateMood();

  // Jump to final
  elProgressFill.style.width = '100%';
  toFinal();
  return true;
}

// ---------- Events ----------

document.getElementById('btn-next').addEventListener('click', nextStage);

document.getElementById('btn-back').addEventListener('click', prevStage);

elBtnReplay.addEventListener('click', resetGame);

elBtnEdit.addEventListener('click', () => {
  elFinal.classList.add('hidden');
  editChoices();
});

elBtnStats.addEventListener('click', () => {
  renderStats();
  elStatsDialog.showModal();
});

elStatsDialog.addEventListener('close', () => {
  // no-op
});

elBtnShare.addEventListener('click', copyShareLink);

// ---------- Init ----------
(function init() {
  if (!tryLoadPlanFromUrl()) {
    resetGame();
  }
})();