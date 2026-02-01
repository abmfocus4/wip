import { useDispatch } from 'react-redux'
import { answerYes, answerNo } from '../store/valentineSlice'
import './QuestionScreen.css'

export default function QuestionScreen({ question, stepIndex, totalQuestions }) {
  const dispatch = useDispatch()

  const handleYes = () => dispatch(answerYes({ stepIndex, totalQuestions }))
  const handleNo = () => dispatch(answerNo(stepIndex))

  return (
    <section className="screen question-screen" id={`step-${stepIndex}`}>
      <div className="question-content">
        <h1 className="question-text">{question.question}</h1>
        {question.subtext && (
          <p className="question-subtext">{question.subtext}</p>
        )}
        {question.image && (
          <img
            src={question.image}
            alt=""
            className="question-image"
          />
        )}
        <div className="buttons">
          <button
            type="button"
            className="btn btn-yes"
            onClick={handleYes}
            aria-label="Yes"
          >
            Yes! 💕
          </button>
          <button
            type="button"
            className="btn btn-no"
            onClick={handleNo}
            aria-label="No"
          >
            No
          </button>
        </div>
      </div>
    </section>
  )
}
