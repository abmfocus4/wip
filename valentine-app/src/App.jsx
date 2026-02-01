import { useSelector, useDispatch } from 'react-redux'
import { reset } from './store/valentineSlice'
import StartScreen from './components/StartScreen'
import QuestionScreen from './components/QuestionScreen'
import ResponseScreen from './components/ResponseScreen'
import { QUESTIONS } from './data/questions'
import './App.css'

function App() {
  const dispatch = useDispatch()
  const { started, currentStep, answers, showingResponse } = useSelector((state) => state.valentine)

  if (!started) {
    return (
      <main className="page-container">
        <StartScreen />
      </main>
    )
  }

  // Show response screen after answering, then continue to next question
  if (showingResponse && answers.length > 0) {
    const lastAnswer = answers[answers.length - 1]
    const q = QUESTIONS[lastAnswer.stepIndex]
    const message = lastAnswer.answer === 'yes' ? q.yesResponse : q.noResponse
    const responseImage = lastAnswer.answer === 'yes' ? q.yesImage : q.noImage
    return (
      <main className="page-container">
        <ResponseScreen
          message={message}
          image={responseImage}
          isYes={lastAnswer.answer === 'yes'}
        />
      </main>
    )
  }

  if (currentStep < QUESTIONS.length) {
    return (
      <main className="page-container">
        <QuestionScreen
          question={QUESTIONS[currentStep]}
          stepIndex={currentStep}
          totalQuestions={QUESTIONS.length}
        />
      </main>
    )
  }

  return (
    <main className="page-container">
      <section className="screen final-screen">
        <div className="final-content">
          <h1 className="final-title">You're my Valentine...forever 💕</h1>
          <img src="/howard-valentine.png" alt="" className="final-image" />
          <p className="final-text">
            Hope you had fun. I love you so much, pooks.
          </p>
          <button
            type="button"
            className="btn-redo"
            onClick={() => {
              dispatch(reset())
              window.location.reload()
            }}
          >
            Redo
          </button>
        </div>
      </section>
    </main>
  )
}

export default App
