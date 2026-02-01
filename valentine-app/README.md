# Will You Be My Valentine? 💕

A React + Redux app that scrolls vertically and asks your special someone to be your Valentine—multiple times, in funny and loving ways—based on whether they tap Yes or No each time.

## Run it

```bash
cd valentine-app
npm install
npm run dev
```

Open the URL in your browser (usually http://localhost:5173) and scroll through the questions. Tap **Yes** or **No**; each answer shows a different message and leads to the next ask.

## Stack

- **React 18** + **Vite**
- **Redux Toolkit** + **react-redux** for current step and answers
- Vertical scroll with **scroll-snap** for full-screen steps

## Customize

- Edit `src/data/questions.js` to change the questions, subtext, and yes/no responses.
- Tweak colors and styles in `src/index.css`, `src/App.css`, and the component CSS files.
