### Category: Algorithms / Theory**

- **Q1: What’s the trade-off between bias and variance?**
In statistics and machine learning, the bias–variance tradeoff is the property of a model that the variance of the parameter estimated across samples can be reduced by increasing the bias in the estimated parameters. The bias–variance dilemma or bias–variance problem is the conflict in trying to simultaneously minimize these two sources of error that prevent supervised learning algorithms from generalizing beyond their training set:

  * What is bias?    
    Bias is the difference between the average prediction of our model and the correct value which we are trying to predict. Model with high bias pays very little attention to the training data and oversimplifies the model. It always leads to high error on training and test data (underfitting).  
    
  * What is variance?    
    Variance is the variability of model prediction for a given data point or a value which tells us spread of our data. Model with high variance pays a lot of attention to training data and does not generalize on the data which it hasn’t seen before. As a result, such models perform very well on training data but has high error rates on test data (overfitting).   
    
  * Mathematically
  
    Let the variable we are trying to predict as Y and other covariates as X. We assume there is a relationship between the two such that

    $$Y=f(X) + e$$

    Where $e$ is the error term and it’s normally distributed with a mean of $0$.

    We will make a model $\hat{f}(X)$ of $f(X)$ using linear regression or any other modeling technique. So the expected squared error at a point $x$ is

    $$Err(x)=E[(Y-\hat{f}(x))^2]$$

    The $Err(x)$ can be further decomposed as

    $$Err(x)=(E[\hat{f}(x)]-f(x))^2+E[(\hat{f}(x)-E[\hat{f}(x)])^2]+\sigma^2_e \\
      =Bias^2+Variance+Irreducible Error
    $$

    $Err(x)$ is the sum of $Bias^2$, variance and the irreducible error.

    Irreducible error is the error that can’t be reduced by creating good models. It is a measure of the amount of noise in our data. Here it is important to understand that no matter how good we make our model, our data will have certain amount of noise or irreducible error that can not be removed.

The bias–variance decomposition is a way of analyzing a learning algorithm's expected generalization error with respect to a particular problem as a sum of three terms, the bias, variance, and a quantity called the irreducible error, resulting from noise in the problem itself.

- **Q2: What is the difference between supervised and unsupervised machine learning?**

- **Q3: How is KNN different from k-means clustering?**

- **Q4: Explain how a ROC curve works.**

- **Q5: Define precision and recall.**

- **Q6: What is Bayes’ Theorem? How is it useful in a machine learning context?**

- **Q7: Why is “Naive” Bayes naive?**
Use the kernel function to ensure that there is no data in the high-dimensional space to calculate the coordinates of the point, and the inner product in the space can be calculated. Many algorithms can express such an inner product form, using kernel energy to ensure that low-dimensional data is calculated in a high-dimensional space.
- **Q8: Explain the difference between L1 and L2 regularization.**

- **Q9: What’s your favorite algorithm, and can you explain it to me in less than a minute?**

- **Q10: What’s the difference between Type I and Type II error?**

- **Q11: What’s a Fourier transform?**

- **Q12: What’s the difference between probability and likelihood?**

- **Q13: What is deep learning, and how does it contrast with other machine learning algorithms?**

- **Q14: What’s the difference between a generative and discriminative model?**

- **Q15- What cross-validation technique would you use on a time series dataset?**

- **Q16- How is a decision tree pruned?**

- **Q17: Which is more important to you? Model accuracy, or model performance?**

- **Q18: What’s the F1 score? How would you use it?**

- **Q19: How would you handle an imbalanced dataset?**

- **Q20: When should you use classification over regression?**

- **Q21: Name an example where ensemble techniques might be useful.**

- **Q22: How do you ensure you’re not overfitting with a model?**

- **Q23: What evaluation approaches would you work to gauge the effectiveness of a machine learning model?**
Use the kernel function to ensure that there is no data in the high-dimensional space to calculate the coordinates of the point, and the inner product in the space can be calculated. Many algorithms can express such an inner product form, using kernel energy to ensure that low-dimensional data is calculated in a high-dimensional space.
- **Q24: How would you evaluate a logistic regression model?**

- **Q25: What’s the “kernel trick” and how is it useful?**
