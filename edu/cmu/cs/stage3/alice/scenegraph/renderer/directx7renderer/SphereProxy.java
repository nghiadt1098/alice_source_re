package edu.cmu.cs.stage3.alice.scenegraph.renderer.directx7renderer;

class SphereProxy
  extends edu.cmu.cs.stage3.alice.scenegraph.renderer.nativerenderer.SphereProxy
{
  SphereProxy() {}
  
  protected native void createNativeInstance();
  
  protected native void releaseNativeInstance();
  
  protected native void onBoundChange(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  protected native void onRadiusChange(double paramDouble);
}
