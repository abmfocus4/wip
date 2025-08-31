# Birthday Quest: Pick Your Perfect Day

A cute, lightweight web game to design the perfect birthday. Make choices across fun stages, earn points, build your mood meter, and reveal your curated plan. Share a link with your partner to preview your choices.

- Stages: Dinner, Outfit, Bar, Cake
- Mechanics: points, synergy bonuses, mood meter, fun facts, replay, edit choices
- Extras: local ranking of favorites (stored in your browser), shareable link with your plan

## Quick start

Open `index.html` in a browser.

Or serve locally for hot reload:

```bash
# Using Python 3
cd birthday-quest
python3 -m http.server 8080
# Visit http://localhost:8080
```

## Deploy free (GitHub Pages)

1. Create a new public repo on GitHub, e.g. `birthday-quest`.
2. Copy the files in this folder to the repo root and push.
3. In the repo Settings → Pages:
   - Source: `Deploy from a branch`
   - Branch: `main` (or `master`) / root
4. Wait 1-2 minutes. Your site will be live at `https://<you>.github.io/<repo>/`.

## Customize

- Edit stages and options in `script.js` under the `stages` array.
- Tweak scoring and synergy in `synergyRules`.
- Adjust colors and spacing in `styles.css`.

## Privacy

No server. All data stays in your browser (localStorage) or in a shareable URL you copy manually.

## License

MIT. Make birthdays magical ✨


// todo:
// i love you even though you think justin beiber is better than the BAND 1D. it's tought but i love you still
