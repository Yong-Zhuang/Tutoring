# Every ML Problem involves **three** key stages (after you have the data and business problem defined obviously)

### Exploration of Data
--

- What do you see?
- What can you say?
- What do you suggest is the cause?
- What should be the next step?
- Is there any anomaly?
- Are you sure there is an anomaly?
- Is something missing?
- Do you think this missingness can be removed?

### Modeling
--

- Try the simplest model, do not be fancy, test the waters --> The Base Model will set the benchmark for worst behavior
- Increase complexity by iterating over multiple techniques, do not use all because that shows your incompetence, choose wisely
- Set the rules for what it means to be good before trying, this way you will reduce your bias
- Check the necessary metrics given the task

### Optimization and Interface
--

- Can you improve the predictive performance?
- How easily can you optimize your model parameters? 
- Is it even possible to optimize your model?
- Can you decrease the uncertainty in the prediction?
- If yes, then by how much?
- What are the assumptions you have made? Are they robust to changes?
- Will your model hold if the data drifts?
- Is it explainable? Does the prediction make sense?
- Is your model consumable? Is there an API or a UI that someone can use and provide feedback on model performance?