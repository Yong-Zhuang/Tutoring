#### Q1. In the following code snippet?
```
def runtime(x):
    n_length = len(x)
    if n_length <= 1:
        return 13
    return runtime(x[:n_length//2] + runtime(x[n_length//2:]))
```
- [ ] O(log n)
- [ ] O(n)
- [ ] O(n log n)
- [ ] O(n^2)
- [ ] O(2^n)

#### Q2. A tourist in Madrid (root node of a tree) wants to visit many places. She wants to start from Madrid and visit cities with direct paths to Madrid first and indirect cities to Madrid sequentially after. What algorithm should she use?

- [ ] Depth First Search
- [ ] Breadth First Search
- [ ] Trim’s algorithm
- [ ] Kruskal’s algorithm

#### Q3. A bag contains 6 yellow chips (labeled A – F) and 6 orange chips(labeled A - F). If two chips are picked one by one, calculate the probability that a yellow chip and an orange chip with the same label will be chosen if the first chip selected is yellow.

- [ ] 1/36
- [ ] 1/22
- [ ] 1/11
- [ ] 1/2
- [ ] 1/121

#### Q4. Identify the correct answer in the following statements regarding principal component analysis (PCA). 

- [ ] The sum of the eigenvalues is exactly the same as the sum of the variance of the variables
- [ ] PCA can be used for qualitative variables
- [ ] PCA can be used for either qualitative or quantitative variables
- [ ] The variables used in PCA do not need to have the same dimensions
- [ ] All principal components are equally important and interpretable

#### Q5. Which of the following statements is not true about tree-based algorithms?

- [ ] Tree-based models can handle both linear and non-linear relationships
- [ ] Tree-based models work well for both categorical and continuous variables
- [ ] Tree-based algorithms have a strong assumption of independence
- [ ] Overfitting is one of the common drawbacks of tree-based models
- [ ] Random forest is an example of tree-based algorithms that is an ensemble learning

#### Q6. Ensembling is a combination of various models to achieve a single powerful model. Which of the following statements is correct?

- [ ] Ensembling is done separately from regularization in tree-based models
- [ ] Voting classifier gives a highest prediction result based on the prediction of all the sub-models
- [ ] Bagging is the process that applies classifiers on small partitions of the dataset and take the average of all the predictions
- [ ] Boosting focuses on correct guesses to maximize the accuracy

#### Q7. One potential issue of using ReLu as the activation function is that it is susceptible to vanishing gradient and slow learning rate.

- [ ] True
- [ ] False

#### Q8. How does dropout work as a regularizer in deep learning?

- [ ] Dropout is a form of model averaging
- [ ]  has a regularizing effect by preventing feature co-adaption
- [ ] Dropout adds noise to the learning process
- [ ] Dropout leads to more sparsity in the hidden units
- [ ] All of the above

#### Q9. Select one correct answer in the following statements.

- [ ] Variational autoencoders (VAE) are better for reconstruction compared to autoencoders
- [ ] One cannot use deep learning models if the length of feature vector is not uniform
- [ ] In graphical neural networks (GNN), message passing is a convolution or aggregation operation on graphs that is used to generate the embeddings by getting the messages
- [ ] Grid search is the only way to tune multiple hyperparameters in deep learning

#### Q10. What is not a regularization method in neural networks?

- [ ] Dropout
- [ ] Batch normalization
- [ ] Early stopping
- [ ] Data augmentation
- [ ] Data standardization

#### Q11. What is not a major component of reinforcement learning?

- [ ] Agent
- [ ] Environment
- [ ] Reward function
- [ ] Value function
- [ ] None of the above

#### Q12. Which of the following statements is a correct characteristic of skip connection?

- [ ] Skip connection does not learn residues
- [ ] Skip connection must go through the intermediate layers
- [ ] Skip connection has no effect on the convergence of model training
- [ ] Skip connection directly passes the output from early layers to later layers
- [ ] Skip connection is limited to only convolutional neural networks (CNN)

#### Q13. In deep learning, a larger batch size is always preferred.

- [ ] True
- [ ] False

#### Q14. In Long short-term memory (LSTM), the first step is to decide which information to retain or discard from cell state, and this decision is made through a sigmoid layer.

- [ ] True
- [ ] False

#### Q15. How do you assess the uncertainty in deep learning models?

- [ ] Cross validation
- [ ] Node dropout
- [ ] Injected data noise
- [ ] None of the above
- [ ] All of the above

#### Q16. One can apply data augmentation to the testing dataset.

- [ ] True
- [ ] False

#### Q17. Tuning which parameter has the most impact on a deep learning model?

#### Q18. What is Attention mechanism?

#### Q19. What are the problem of imbalanced datasets? How does one solve them?

#### Q20. How will you detect if your learning rate is too high or too low?
