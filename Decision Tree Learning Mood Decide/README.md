﻿# Use decision tree learning to find out what makes a day have good mood

This code is able to be used with any decision tree learning problem. All that needs to change is the input file name.

## Evaluation of 2 kinds of pruning methods implemented:
Reduced Error Pruning:  using a validation set appears to produce a better result. But it only has 2/3 the data to build the decision tree with.

Pessimistic Estimate Pruning: It has the advantage of having all the data when building the decision tree, however, the pruning is only useful when the decision tree misclassifies some of the training data.

Current Result (The training data is growing):

Validation set approach:

->FULFILLING PROJECT? 
[Yes->TRUE No->DAY OF WEEK [Monday->FALSE Tuesday->TRUE Wednesday->FALSE Thursday->TRUE Friday->FALSE Saturday->TRUE Sunday->TRUE ] ] 

Pessimistic Estimate appraoch:

->DAY OF WEEK [Monday->GOOD MEAL? [Yes->TRUE No->FALSE ] Tuesday->TRUE Wednesday->TEMPERATURE [Hot->TRUE Warm->FALSE Cool->TRUE Cold->TRUE ] Thursday->TRUE Friday->FALSE Saturday->TRUE Sunday->TRUE ] 
