package icbm.models;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class MFaSheShiMuo0 extends ModelBase
{
  //fields
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public MFaSheShiMuo0()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Shape4 = new ModelRenderer(this, 0, 35);
      Shape4.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape4.setRotationPoint(-1F, 16F, 0F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 15, 30);
      Shape5.addBox(0F, 0F, 0F, 10, 1, 5);
      Shape5.setRotationPoint(-5F, 17F, -2F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0.5235988F, 0F, 0F);
  }
  
  @Override
public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape4.render(f5);
    Shape5.render(f5);
  }
  
  public void render(float f5)
  {
    Shape4.render(f5);
    Shape5.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}