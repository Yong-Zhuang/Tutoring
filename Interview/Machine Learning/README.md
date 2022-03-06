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
Well, you must know that model accuracy is only a subset of model performance. The accuracy of the model and performance of the model are directly proportional and hence better the performance of the model, more accurate are the predictions.

- **Q18: What’s the F1 score? How would you use it?**
The F1-score combines the precision and recall of a classifier into a single metric by taking their harmonic mean.

The F1-score of a classification model is calculated as follows:

$$\frac{2(P * R)}{P+R}$$​​ 

PP = the precision.  A low precision can also indicate a large number of False Positives.
RR = the recall. A low recall indicates many False Negatives.

- **Q19: How would you handle an imbalanced dataset?**
  - 1. Choose Proper Evaluation Metric
  F1 score keeps the balance between precision and recall and improves the score only if the classifier identifies more of a certain class correctly.

  - 2. Resampling (Oversampling and Undersampling)

  - 3. SMOTE
  Synthetic Minority Oversampling Technique or SMOTE is another technique to oversample the minority class. Simply adding duplicate records of minority class often don’t add any new information to the model. In SMOTE new instances are synthesized from the existing data. If we explain it in simple words, SMOTE looks into minority class instances and use k nearest neighbor to select a random nearest neighbor, and a synthetic instance is created randomly in feature space.

  - 4. BalancedBaggingClassifier
  When we try to use a usual classifier to classify an imbalanced dataset, the model favors the majority class due to its larger volume presence. A BalancedBaggingClassifier is the same as a sklearn classifier but with additional balancing. It includes an additional step to balance the training set at the time of fit for a given sampler. This classifier takes two special parameters “sampling_strategy” and “replacement”. The sampling_strategy decides the type of resampling required (e.g. ‘majority’ – resample only the majority class, ‘all’ – resample all classes, etc) and replacement decides whether it is going to be a sample with replacement or not.

  - 5. Threshold moving

- **Q20: When should you use classification over regression?**

Classification is about identifying group membership while regression technique involves predicting a response. Both techniques are related to prediction, where classification predicts the belonging to a class whereas regression predicts the value from a continuous set. Classification technique is preferred over regression when the results of the model need to return the belongingness of data points in a dataset to specific explicit categories. (For instance, when you want to find out whether a name is male or female instead of just finding it how correlated they are with male and female names.

- **Q21: Name an example where ensemble techniques might be useful.**

Ensemble Technique is a machine learning method or technique that combines various base models in order to produce one optimal and predictive model. reduce overfitting and more robust

A good example of how ensemble methods are commonly used to solve data science problems is the random forest algorithm (having multiple CART models). It performs better compared to individual CART model by classifying a new object where each tree gives “votes” for that class and the forest chooses the classification having the most votes (over all the trees in the forest). In case of regression, it takes the average of outputs of different trees.

- **Q22: How do you ensure you’re not overfitting with a model?**
  - 1- Keep the model simpler: remove some of the noise in the training data.
  - 2- Use cross-validation techniques such as k-folds cross-validation.
  - 3- Use regularization techniques such as LASSO

- **Q23: What evaluation approaches would you work to gauge the effectiveness of a machine learning model?**
Use the kernel function to ensure that there is no data in the high-dimensional space to calculate the coordinates of the point, and the inner product in the space can be calculated. Many algorithms can express such an inner product form, using kernel energy to ensure that low-dimensional data is calculated in a high-dimensional space.
- **Q24: How would you evaluate a logistic regression model?**
  - Accuracy Score
  - Recall: Recall can be thought of as a measure of a classifiers completeness. A low recall indicates many False Negatives.
  - Precision: Precision can be thought of as a measure of a classifiers exactness. A low precision can also indicate a large number of False Positives.
  - F1 Score, if you are dealing with a imbalanced dataset this is a must. If you are looking to select a model that is balanced between precision and recall F measure should be used.

- **Q25: What’s the “kernel trick” and how is it useful?**

Kernel trick allows the inner product of mapping function instead of the data points. The trick is to identify the kernel functions which can be represented in place of the inner product of mapping functions. Kernel functions allow easy computation. In essence, what the kernel trick does for us is to offer a more efficient and less expensive way to transform data into higher dimensions.