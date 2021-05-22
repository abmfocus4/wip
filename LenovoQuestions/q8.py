# Optimized method to find equilibrium index of an list O(n)
def equilibriumIndex(A): 

	# total stores sum of all elements of the list
	total = sum(A)

	# right stores sum of elements of sub-list A[i+1..n)
	right = 0

	# maintain list of indices
	indices = []

	# traverse list from right to left
	for i in reversed(range(len(A))):

		""" i is equilibrium index if sum of elements of sub-list:
			A[0..i-1] is equal to the sum of elements of sub-list
			A[i+1..n) i.e. (A[0] + A[1] + .. + A[i-1]) =
			(A[i+1] + A[i+2] + .. + A[n-1]) """

		# sum of elements of left sub-list A[0..i-1] is
		# (total - (A[i] + right))
		if right == total - (A[i] + right):
			indices.append(i)

		# new right = A[i] + (A[i+1] + A[i+2] + .. + A[n-1])
		right += A[i]

	print("Equilibrium Index found at", indices)


# Program to find the equilibrium index of an list
if __name__ == '__main__':

	A = [0, -3, 5, -4, -2, 3, 1, 0]

	equilibriumIndex(A)
