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
const elStageSection = document.getElementById('stage');
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
const elCakeOverlay = document.getElementById('cake-overlay');
const elSfxBlow = document.getElementById('sfx-blow');
const elCongrats = document.getElementById('congrats-overlay');
const elBtnSavePdf = document.getElementById('btn-save-pdf');
const elBtnCongratsClose = document.getElementById('btn-congrats-close');
const elWelcome = document.getElementById('welcome');
const elHeader = document.getElementById('app-header');
const elHud = document.getElementById('hud');
const elBtnTosAgree = document.getElementById('btn-tos-agree');
const elBtnTosStronglyAgree = document.getElementById('btn-tos-strongly-agree');
const elConfetti = document.getElementById('confetti');
const elAppRoot = document.getElementById('app');
const elSfxConfetti = document.getElementById('sfx-confetti');
const elCoach = document.getElementById('cheer-coach');
const elCoachText = document.getElementById('coach-text');

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
  if (elCoach) elCoach.classList.remove('hidden');

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

    // Links: Google Maps + Website (or search fallback)
    const links = document.createElement('div');
    links.className = 'card-links';
    const query = option.mapsQuery || `${option.title} near me`;
    const mapsUrl = option.mapsUrl || `https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(query)}`;
    const aMaps = document.createElement('a');
    aMaps.href = mapsUrl;
    aMaps.target = '_blank';
    aMaps.rel = 'noopener noreferrer';
    aMaps.textContent = 'Open in Maps';
    links.appendChild(aMaps);

    const websiteUrl = option.website || '';
    const aWeb = document.createElement('a');
    aWeb.target = '_blank';
    aWeb.rel = 'noopener noreferrer';
    if (websiteUrl) {
      aWeb.href = websiteUrl;
      aWeb.textContent = 'Website';
      links.appendChild(aWeb);
    } else {
      // Fallback: Google search to help find a site
      const searchUrl = `https://www.google.com/search?q=${encodeURIComponent(option.title + ' official site')}`;
      aWeb.href = searchUrl;
      aWeb.textContent = 'Website';
      links.appendChild(aWeb);
    }

    card.appendChild(hero);
    card.appendChild(title);
    card.appendChild(desc);
    card.appendChild(tags);
    card.appendChild(links);

    card.addEventListener('click', () => selectOption(stage.id, option.id));
    card.addEventListener('keydown', (e) => { if (e.key === 'Enter' || e.key === ' ') { e.preventDefault(); selectOption(stage.id, option.id); } });

    elOptions.appendChild(card);
  }

  elBtnBack.disabled = state.index === 0;
  elBtnNext.disabled = !selectedOptionId;

  const total = stages.length;
  elProgressText.textContent = `Stage ${state.index + 1} / ${total}`;
  elProgressFill.style.width = `${((state.index) / total) * 100}%`;

  // Update coach text
  if (elCoachText) {
    const prompts = [
      'You got this! 💪',
      'Trust your vibe ✨',
      'Great pick! 😍',
      'I believe in you 🙌',
      'Chef’s kiss 👩🏻‍🍳💋',
      'Whatever my booba says 💋'
    ];
    const perStage = {
      dinner: 'Mmm, yummy pick… 🍝',
      outfit: 'Serve the look! 👗',
      bar: 'Time to toast? 🥂',
      cake: 'Save room for cake 🎂',
    };
    const stageId = stage.id;
    const chosen = state.choicesByStage[stageId];
    if (chosen) {
      elCoachText.textContent = prompts[Math.floor(Math.random() * prompts.length)];
    } else {
      elCoachText.textContent = perStage[stageId] || 'You got this!';
    }
  }
}

let toastTimer = null;
function showToast(message) {
  elToast.textContent = message;
  elToast.classList.add('show');
  if (toastTimer) clearTimeout(toastTimer);
  // Base 2.8s + 45ms per character, clamped 3s–7s
  const duration = clamp(3000, 2800 + message.length * 45, 7000);
  toastTimer = setTimeout(() => elToast.classList.remove('show'), duration);
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

// ---------- Cake Effects ----------
let audioCtx = null;
function initAudio() {
  if (!audioCtx) {
    try { audioCtx = new (window.AudioContext || window.webkitAudioContext)(); } catch (_) { audioCtx = null; }
  }
  return audioCtx;
}

async function playBlowWhoosh() {
  if (elSfxBlow) {
    try {
      elSfxBlow.currentTime = 0;
      elSfxBlow.volume = 0.6;
      await elSfxBlow.play();
      return;
    } catch (_) {
      // will fallback to synthesized sound below
    }
  }
  const ctx = initAudio();
  if (!ctx) return;
  const duration = 0.55;
  const noiseBuffer = ctx.createBuffer(1, ctx.sampleRate * duration, ctx.sampleRate);
  const data = noiseBuffer.getChannelData(0);
  for (let i = 0; i < data.length; i += 1) {
    data[i] = (Math.random() * 2 - 1) * Math.pow(1 - i / data.length, 1.1);
  }
  const noise = ctx.createBufferSource();
  noise.buffer = noiseBuffer;
  const highpass = ctx.createBiquadFilter();
  highpass.type = 'highpass';
  highpass.frequency.value = 180;
  const lowpass = ctx.createBiquadFilter();
  lowpass.type = 'lowpass';
  lowpass.frequency.value = 900;
  const gain = ctx.createGain();
  const now = ctx.currentTime;
  gain.gain.setValueAtTime(0.0001, now);
  gain.gain.exponentialRampToValueAtTime(0.08, now + 0.06);
  gain.gain.exponentialRampToValueAtTime(0.006, now + duration);
  noise.connect(highpass).connect(lowpass).connect(gain).connect(ctx.destination);
  noise.start();
  noise.stop(now + duration);
}

function triggerCandleBlowEffect() {
  return new Promise((resolve) => {
    if (!elCakeOverlay) { resolve(); return; }
    elCakeOverlay.classList.remove('blown');
    elCakeOverlay.classList.add('show');

    const smokes = elCakeOverlay.querySelectorAll('.smoke');
    smokes.forEach((s, i) => s.style.setProperty('--i', String(i)));

    setTimeout(() => {
      elCakeOverlay.classList.add('blown');
      // Try to play after the visual change; if blocked, we also prime on first click elsewhere
      playBlowWhoosh();
    }, 350);

    setTimeout(() => {
      elCakeOverlay.classList.remove('show');
      elCakeOverlay.classList.remove('blown');
      resolve();
    }, 1900);
  });
}

function toFinal() {
  elFinal.classList.remove('hidden');
  if (elStageSection) elStageSection.classList.add('hidden');
  if (elStageSection) elStageSection.classList.add('hidden');
  if (elCoach) elCoach.classList.add('hidden');

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
    // final step from last stage
    elProgressFill.style.width = '100%';
    const currentStage = stages[state.index];
    if (currentStage?.id === 'cake') {
      triggerCandleBlowEffect().then(() => {
        toFinal();
      });
    } else {
      toFinal();
    }
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
  if (elStageSection) elStageSection.classList.remove('hidden');
   if (elCoach) elCoach.classList.remove('hidden');
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
  if (elStageSection) elStageSection.classList.remove('hidden');
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

// ---------- PDF Generation & Congrats Flow ----------
async function generatePdfFromChoices() {
  const { jsPDF } = window.jspdf || {};
  if (!jsPDF) {
    showToast('PDF library failed to load.');
    return null;
  }
  const doc = new jsPDF();
  const margin = 16;
  let y = 20;
  doc.setFont('helvetica', 'bold');
  doc.setFontSize(18);
  doc.text('Perfect Day — Birthday Quest', margin, y);
  y += 8;
  doc.setDrawColor(150);
  doc.line(margin, y, 210 - margin, y);
  y += 10;
  doc.setFont('helvetica', 'normal');
  doc.setFontSize(12);
  for (const stage of stages) {
    const optId = state.choicesByStage[stage.id];
    if (!optId) continue;
    const opt = getOption(stage.id, optId);
    if (!opt) continue;
    const stageTitle = stage.title.replace(/Stage \d+ — /, '');
    doc.setFont('helvetica', 'bold');
    doc.text(`${stageTitle}: ${opt.title}`, margin, y);
    y += 6;
    doc.setFont('helvetica', 'normal');
    const descLines = doc.splitTextToSize(opt.desc, 210 - margin * 2);
    doc.text(descLines, margin, y);
    y += descLines.length * 6 + 6;
    if (y > 280) { doc.addPage(); y = 20; }
  }
  y += 4;
  doc.setFont('helvetica', 'bold');
  doc.text(`Total Points: ${state.points}`, margin, y);
  return doc;
}

function playKissSound() {
  const ctx = initAudio();
  if (!ctx) return;
  // Kiss: a short filtered noise burst with quick pitchy pop
  const duration = 0.22;
  const noiseBuffer = ctx.createBuffer(1, ctx.sampleRate * duration, ctx.sampleRate);
  const data = noiseBuffer.getChannelData(0);
  for (let i = 0; i < data.length; i += 1) {
    data[i] = (Math.random() * 2 - 1) * Math.pow(1 - i / data.length, 1.4);
  }
  const noise = ctx.createBufferSource();
  noise.buffer = noiseBuffer;
  const bp = ctx.createBiquadFilter();
  bp.type = 'bandpass';
  bp.frequency.value = 1500;
  bp.Q.value = 2.5;
  const gain = ctx.createGain();
  const now = ctx.currentTime;
  gain.gain.setValueAtTime(0.0001, now);
  gain.gain.exponentialRampToValueAtTime(0.12, now + 0.02);
  gain.gain.exponentialRampToValueAtTime(0.004, now + duration);
  noise.connect(bp).connect(gain).connect(ctx.destination);
  noise.start();
  noise.stop(now + duration);
}

function showCongratsOverlay() {
  if (!elCongrats) return;
  elCongrats.classList.add('show');
  // trigger hearts float loop restart by reflow (optional)
  void elCongrats.offsetWidth;
  playKissSound();
}

function hideCongratsOverlay() {
  if (!elCongrats) return;
  elCongrats.classList.remove('show');
}

function buildLoveLetterText() {
  const lines = [];
  lines.push('My Love,');
  lines.push('');
  lines.push('Today I designed a perfect birthday just for you. Every choice was a little love note.');
  lines.push('');
  for (const stage of stages) {
    const optId = state.choicesByStage[stage.id];
    if (!optId) continue;
    const opt = getOption(stage.id, optId);
    if (!opt) continue;
    const stageTitle = stage.title.replace(/Stage \d+ — /, '');
    lines.push(`${stageTitle}: ${opt.title} — ${opt.desc}`);
  }
  lines.push('');
  lines.push(`Our mood meter says ${state.mood}% happy, but my heart says 100%.`);
  lines.push(`Total points: ${state.points} (but who’s counting when it’s love?)`);
  lines.push('');
  lines.push('I love you—today, tomorrow, and for every birthday that follows.');
  lines.push('');
  lines.push('Yours,');
  lines.push('Your Partner');
  return lines.join('\n');
}

async function onSavePdf() {
  // Build a custom love letter as a PDF
  const { jsPDF } = window.jspdf || {};
  if (!jsPDF) { showToast('PDF library failed to load.'); return; }
  const doc = new jsPDF();
  const text = buildLoveLetterText();
  const margin = 16;
  doc.setFont('times', 'normal');
  doc.setFontSize(14);
  const wrapped = doc.splitTextToSize(text, 210 - margin * 2);
  doc.text(wrapped, margin, 24);
  try {
    doc.save('A-Love-Letter.pdf');
    setTimeout(() => { showCongratsOverlay(); }, 400);
  } catch (_) {
    showToast('Could not save PDF.');
  }
}

if (elBtnSavePdf) {
  elBtnSavePdf.addEventListener('click', onSavePdf);
}
if (elBtnCongratsClose) {
  elBtnCongratsClose.addEventListener('click', hideCongratsOverlay);
}

// ---------- Init ----------
(function init() {
  // Always show welcome page first as a dedicated page
  if (elWelcome) elWelcome.classList.add('show');
  // Hide app chrome until accepted
  if (elHeader) elHeader.classList.add('hidden');
  if (elHud) elHud.classList.add('hidden');
  if (elStageSection) elStageSection.classList.add('hidden');
  if (elFinal) elFinal.classList.add('hidden');
  if (elCoach) elCoach.classList.add('hidden');
})();

function startGameAfterTos() {
  localStorage.setItem('bq_tos_accepted', '1');
  if (elWelcome) elWelcome.classList.remove('show');
  // If URL has plan, load it; else start fresh
  if (!tryLoadPlanFromUrl()) {
    resetGame();
  }
}

if (elBtnTosStronglyAgree) elBtnTosStronglyAgree.addEventListener('click', startGameAfterTos);
if (elBtnTosAgree) elBtnTosAgree.addEventListener('click', () => {
  // Play bummer sound and prompt for more enthusiasm
  const srcEl = document.getElementById('sfx-bummer');
  if (srcEl && srcEl.querySelector('source')?.getAttribute('src')) {
    try { srcEl.currentTime = 0; srcEl.volume = 0.85; srcEl.play(); } catch (_) {}
  } else {
    const ctx = initAudio();
    if (ctx) {
      const osc = ctx.createOscillator();
      osc.type = 'sawtooth';
      const gain = ctx.createGain();
      const now = ctx.currentTime;
      osc.frequency.setValueAtTime(520, now);
      osc.frequency.exponentialRampToValueAtTime(160, now + 0.32);
      gain.gain.setValueAtTime(0.0001, now);
      gain.gain.exponentialRampToValueAtTime(0.22, now + 0.02);
      gain.gain.exponentialRampToValueAtTime(0.001, now + 0.34);
      osc.connect(gain).connect(ctx.destination);
      osc.start(now);
      osc.stop(now + 0.36);
    }
  }
  showToast('Try again mister, there\'s only one option 🔫');
});

// ---------- Confetti ----------
function playConfettiSound() {
  // Try DOM audio first if a source is provided
  if (elSfxConfetti && elSfxConfetti.querySelector('source')?.getAttribute('src')) {
    try { elSfxConfetti.currentTime = 0; elSfxConfetti.volume = 0.8; elSfxConfetti.play(); return; } catch (_) {}
  }
  // Fallback synth: celebratory burst (noise + chord + sparkles)
  const ctx = initAudio();
  if (!ctx) return;
  const now = ctx.currentTime;

  const master = ctx.createGain();
  master.gain.setValueAtTime(0.6, now);
  master.connect(ctx.destination);

  // Noise layer (confetti whoosh)
  const nDuration = 0.28;
  const nBuf = ctx.createBuffer(1, ctx.sampleRate * nDuration, ctx.sampleRate);
  const nData = nBuf.getChannelData(0);
  for (let i = 0; i < nData.length; i += 1) {
    // light taper
    const t = i / nData.length;
    const env = Math.pow(1 - t, 0.8);
    nData[i] = (Math.random() * 2 - 1) * env;
  }
  const nSrc = ctx.createBufferSource();
  nSrc.buffer = nBuf;
  const hp = ctx.createBiquadFilter(); hp.type = 'highpass'; hp.frequency.value = 700;
  const lp = ctx.createBiquadFilter(); lp.type = 'lowpass'; lp.frequency.value = 3500;
  const nGain = ctx.createGain();
  nGain.gain.setValueAtTime(0.0001, now);
  nGain.gain.exponentialRampToValueAtTime(0.28, now + 0.01);
  nGain.gain.exponentialRampToValueAtTime(0.002, now + nDuration);
  nSrc.connect(hp).connect(lp).connect(nGain).connect(master);
  nSrc.start(now);
  nSrc.stop(now + nDuration + 0.02);

  // Chord layer (festive)
  const chordFreqs = [880, 1318.5]; // A5, E6
  chordFreqs.forEach((freq, idx) => {
    const osc = ctx.createOscillator();
    osc.type = 'sawtooth';
    osc.frequency.setValueAtTime(freq, now);
    const oGain = ctx.createGain();
    oGain.gain.setValueAtTime(0.0001, now);
    oGain.gain.exponentialRampToValueAtTime(0.12, now + 0.01);
    oGain.gain.exponentialRampToValueAtTime(0.003, now + 0.4 + idx * 0.02);
    osc.connect(oGain).connect(master);
    osc.start(now);
    osc.stop(now + 0.45 + idx * 0.02);
  });

  // Sparkle pings
  [2000, 2400, 3000].forEach((freq, i) => {
    const start = now + 0.05 * i;
    const ping = ctx.createOscillator();
    ping.type = 'sine';
    ping.frequency.setValueAtTime(freq, start);
    const pGain = ctx.createGain();
    pGain.gain.setValueAtTime(0.0001, start);
    pGain.gain.exponentialRampToValueAtTime(0.08, start + 0.006);
    pGain.gain.exponentialRampToValueAtTime(0.001, start + 0.12);
    ping.connect(pGain).connect(master);
    ping.start(start);
    ping.stop(start + 0.14);
  });
}

function spawnConfettiBurst(centerX = window.innerWidth / 2, count = 120) {
  if (!elConfetti) return;
  const colors = ['#8b5cf6', '#22d3ee', '#f43f5e', '#f59e0b', '#10b981', '#e9ebf1'];
  // radial burst from a center top area
  const originY = Math.max(40, window.innerHeight * 0.18);
  for (let i = 0; i < count; i += 1) {
    const piece = document.createElement('div');
    piece.className = 'confetti-piece';
    const size = 7 + Math.random() * 7;
    piece.style.width = `${size}px`;
    piece.style.height = `${size * 1.2}px`;
    piece.style.left = `${centerX}px`;
    piece.style.top = `${originY}px`;
    piece.style.background = colors[Math.floor(Math.random() * colors.length)];
    // Trajectory
    const angle = (Math.random() * Math.PI * 2);
    const distance = 120 + Math.random() * 260;
    const dx = Math.cos(angle) * distance;
    const dy = Math.sin(angle) * distance;
    piece.style.setProperty('--dx', `${dx}px`);
    piece.style.setProperty('--dy', `${dy}px`);
    piece.style.setProperty('--rot', `${(Math.random() * 2 - 1) * 720}deg`);
    piece.style.animationDuration = `${0.9 + Math.random() * 0.4}s`;
    piece.style.animationDelay = `${Math.random() * 0.06}s`;
    elConfetti.appendChild(piece);
    // cleanup each piece
    setTimeout(() => piece.remove(), 1400);
  }
  playConfettiSound();
  if (elAppRoot) {
    elAppRoot.classList.remove('shake');
    // restart animation by forcing reflow
    void elAppRoot.offsetWidth;
    elAppRoot.classList.add('shake');
    setTimeout(() => elAppRoot.classList.remove('shake'), 320);
  }
}

// Enhance ToS acceptance with confetti + quick fade of overlay
function startGameAfterTos() {
  localStorage.setItem('bq_tos_accepted', '1');
  if (elWelcome) elWelcome.classList.remove('show');
  if (elHeader) elHeader.classList.remove('hidden');
  if (elHud) elHud.classList.remove('hidden');
  if (elStageSection) elStageSection.classList.remove('hidden');
  if (elCoach) elCoach.classList.remove('hidden');
  spawnConfettiBurst(window.innerWidth / 2, 140);
  // Start fresh or load shared plan after small delay for confetti impact
  setTimeout(() => {
    if (!tryLoadPlanFromUrl()) {
      resetGame();
    }
  }, 200);
}