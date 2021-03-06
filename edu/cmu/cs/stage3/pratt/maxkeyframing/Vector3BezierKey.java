package edu.cmu.cs.stage3.pratt.maxkeyframing;

import java.util.StringTokenizer;
import javax.vecmath.Vector3d;





















public class Vector3BezierKey
  extends BezierKey
{
  public Vector3BezierKey(double time, Vector3d value, Vector3d incomingControlPoint, Vector3d outgoingControlPoint)
  {
    super(time, new double[] { x, y, z }, new double[] { x, y, z }, new double[] { x, y, z });
  }
  
  private Vector3d vSample = new Vector3d();
  
  public Object createSample(double[] components) {
    vSample.x = components[0];
    vSample.y = components[1];
    vSample.z = components[2];
    return vSample;
  }
  
  public static Vector3BezierKey valueOf(String s)
  {
    StringTokenizer st = new StringTokenizer(s, " \t,[]");
    
    String className = st.nextToken();
    double time = Double.parseDouble(st.nextToken());
    Vector3d value = new Vector3d(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
    Vector3d incomingControlPoint = new Vector3d(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
    Vector3d outgoingControlPoint = new Vector3d(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
    
    return new Vector3BezierKey(time, value, incomingControlPoint, outgoingControlPoint);
  }
}
