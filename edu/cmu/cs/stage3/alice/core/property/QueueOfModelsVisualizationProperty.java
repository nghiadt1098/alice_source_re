package edu.cmu.cs.stage3.alice.core.property;

import edu.cmu.cs.stage3.alice.core.visualization.QueueOfModelsVisualization;

public class QueueOfModelsVisualizationProperty extends CollectionOfModelsVisualizationProperty
{
  public QueueOfModelsVisualizationProperty(edu.cmu.cs.stage3.alice.core.Element owner, String name, QueueOfModelsVisualization defaultValue) {
    super(owner, name, defaultValue, QueueOfModelsVisualization.class);
  }
  
  public QueueOfModelsVisualization getQueueOfModelsVisualizationValue() { return (QueueOfModelsVisualization)getCollectionOfModelsVisualizationValue(); }
}