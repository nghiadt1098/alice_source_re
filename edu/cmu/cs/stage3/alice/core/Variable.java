package edu.cmu.cs.stage3.alice.core;

import edu.cmu.cs.stage3.alice.core.property.ClassProperty;
import edu.cmu.cs.stage3.alice.core.property.ValueProperty;
import edu.cmu.cs.stage3.lang.Messages;




















public class Variable
  extends Expression
{
  public Variable() {}
  
  public final ValueProperty value = new ValueProperty(this, "value", null);
  public final ClassProperty valueClass = new ClassProperty(this, "valueClass", null);
  public boolean isWatch = false;
  
  public Object getValue() {
    return value.getValue();
  }
  
  public Class getValueClass() {
    return (Class)valueClass.getValue();
  }
  
  protected void valueClassValueChanging(Class clsToBe) {
    if (clsToBe != null) {
      Object o = value.getValue();
      if ((o instanceof Expression)) {
        Expression expression = (Expression)o;
        if (clsToBe.isAssignableFrom(expression.getValueClass())) {
          value.setOverrideValueClass(clsToBe);
        }
        else if (!Element.s_isLoading)
        {

          throw new RuntimeException(Messages.getString("cannot_change_valueClass_to_") + clsToBe + " " + Messages.getString("when_value_is_") + o);
        }
        
      }
      else if ((o == null) || (clsToBe.isInstance(o))) {
        value.setOverrideValueClass(clsToBe);
      }
      else if (!Element.s_isLoading)
      {

        throw new RuntimeException(Messages.getString("cannot_change_valueClass_to_") + clsToBe + " " + Messages.getString("when_value_is_") + o);
      }
    }
    else
    {
      value.setOverrideValueClass(null);
    }
  }
  
  protected void valueValueChanging(Object o) {
    if (!Element.s_isLoading)
    {

      if (o != null)
      {

        if ((o instanceof Expression)) {
          Expression expression = (Expression)o;
          Class cls = expression.getValueClass();
          Class valueCls = (Class)valueClass.getValue();
          if (valueCls != null)
          {

            if (!valueCls.isAssignableFrom(cls))
            {

              throw new RuntimeException(o + " " + Messages.getString("is_not_an_instance_of_") + valueClass + Messages.getString("___it_is_an_instance_of_") + cls);
            }
          }
        }
        else {
          Class cls = o.getClass();
          Class valueCls = (Class)valueClass.getValue();
          if (valueCls != null)
          {

            if (!valueCls.isAssignableFrom(cls))
            {

              throw new RuntimeException(o + " " + Messages.getString("is_not_an_instance_of_") + valueClass + Messages.getString("___it_is_an_instance_of_") + cls); }
          }
        }
      }
    }
  }
  
  protected void valueValueChanged(Object o) {
    onExpressionChange();
  }
  
  protected void propertyChanging(Property property, Object o)
  {
    if (property == value) {
      valueValueChanging(o);
    } else if (property == valueClass) {
      valueClassValueChanging((Class)o);
    } else {
      super.propertyChanging(property, o);
    }
  }
  
  protected void propertyChanged(Property property, Object o) {
    if (property == value) {
      valueValueChanged(o);
    } else if (property != valueClass)
    {

      super.propertyChanged(property, o);
    }
  }
}
