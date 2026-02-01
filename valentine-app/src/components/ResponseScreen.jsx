import { useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { continueToNext } from '../store/valentineSlice'
import './ResponseScreen.css'

export default function ResponseScreen({ message, image, isYes }) {
  const dispatch = useDispatch()

  useEffect(() => {
    if (isYes) {
      const t = setTimeout(() => dispatch(continueToNext()), 3000)
      return () => clearTimeout(t)
    }
  }, [isYes, dispatch])

  return (
    <section className={`screen response-screen ${isYes ? 'response-yes' : 'response-no'}`}>
      <div className="response-content">
        <p className="response-text">{message}</p>
        {image && <img src={image} alt="" className="response-image" />}
        {isYes ? (
          <p className="auto-continue">Taking you to the final page...</p>
        ) : (
          <button
            type="button"
            className="btn-continue"
            onClick={() => dispatch(continueToNext())}
          >
            Again →
          </button>
        )}
      </div>
    </section>
  )
}
