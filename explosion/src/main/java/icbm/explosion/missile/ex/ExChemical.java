package icbm.explosion.missile.ex;

import icbm.ModelICBM;
import icbm.Settings;
import icbm.core.ICBMCore;
import icbm.explosion.explosive.blast.BlastChemical;
import icbm.explosion.missile.types.Missile;
import icbm.explosion.model.missiles.MMDuQi;
import icbm.explosion.model.missiles.MMGanRanDu;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import calclavia.lib.recipe.RecipeUtility;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExChemical extends Missile
{
    public ExChemical(String mingZi, int tier)
    {
        super(mingZi, tier);
    }

    @Override
    public void init()
    {
        if (this.getTier() == 1)
        {
            RecipeUtility.addRecipe(new ShapedOreRecipe(this.getItemStack(), new Object[] { "@@@", "@?@", "@@@", '@', ICBMCore.itemPoisonPowder, '?', debilitation.getItemStack() }), "Chemical", Settings.CONFIGURATION, true);
        }
        else if (this.getTier() == 2)
        {
            RecipeUtility.addRecipe(new ShapedOreRecipe(this.getItemStack(2), new Object[] { " @ ", "@?@", " @ ", '?', Item.rottenFlesh, '@', chemical.getItemStack() }), "Contagious", Settings.CONFIGURATION, true);
        }
    }

    @Override
    public void doCreateExplosion(World world, double x, double y, double z, Entity entity)
    {
        if (this.getTier() == 1)
        {
            new BlastChemical(world, entity, x, y, z, 20, 20 * 30, false).setPoison().setRGB(0.8f, 0.8f, 0).explode();
        }
        else if (this.getTier() == 2)
        {
            new BlastChemical(world, entity, x, y, z, 20, 20 * 30, false).setContagious().setRGB(0.3f, 0.8f, 0).explode();
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelICBM getMissileModel()
    {
        if (this.getTier() == 1)
        {
            return new MMDuQi();
        }
        else if (this.getTier() == 2)
        {
            return new MMGanRanDu();
        }

        return null;
    }

}
