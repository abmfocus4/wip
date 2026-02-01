import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  started: false,
  currentStep: 0,
  answers: [], // each entry: { stepIndex, answer: 'yes' | 'no' }
  hasSaidYes: false,
  showingResponse: false, // when true, show response; when false, show next question
}

export const valentineSlice = createSlice({
  name: 'valentine',
  initialState,
  reducers: {
    start: (state) => {
      state.started = true
    },
    answerYes: (state, action) => {
      const { stepIndex, totalQuestions } = action.payload
      state.answers.push({ stepIndex, answer: 'yes' })
      state.hasSaidYes = true
      state.currentStep = totalQuestions // skip to final page
      state.showingResponse = true
    },
    answerNo: (state, action) => {
      const stepIndex = action.payload
      state.answers.push({ stepIndex, answer: 'no' })
      state.currentStep += 1
      state.showingResponse = true
    },
    continueToNext: (state) => {
      state.showingResponse = false
    },
    reset: () => initialState,
  },
})

export const { start, answerYes, answerNo, continueToNext, reset } = valentineSlice.actions
export default valentineSlice.reducer
