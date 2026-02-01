import { useDispatch } from 'react-redux'
import { start } from '../store/valentineSlice'
import './StartScreen.css'

export default function StartScreen() {
  const dispatch = useDispatch()

  return (
    <section className="screen start-screen">
      <div className="start-content">
        <h1 className="start-title">Hey, I have something for you 👉👈</h1>
        <p className="start-text">
          I want to ask you a very serious question.
        </p>
        <p className="start-subtext">
          Feel free to play hard to get... I've got all the time in the world. 😏
        </p>
        <button
          type="button"
          className="btn-start"
          onClick={() => dispatch(start())}
        >
          Let's go →
        </button>
      </div>
    </section>
  )
}
