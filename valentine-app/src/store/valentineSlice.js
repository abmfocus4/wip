import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  currentStep: 0,
  answers: [], // each entry: { stepIndex, answer: 'yes' | 'no' }
  hasSaidYes: false,
  showingResponse: false, // when true, show response; when false, show next question
}

export const valentineSlice = createSlice({
  name: 'valentine',
  initialState,
  reducers: {
    answerYes: (state, action) => {
      const stepIndex = action.payload
      state.answers.push({ stepIndex, answer: 'yes' })
      state.hasSaidYes = true
      state.currentStep += 1
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

export const { answerYes, answerNo, continueToNext, reset } = valentineSlice.actions
export default valentineSlice.reducer
