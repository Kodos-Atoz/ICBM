package icbm.sentry.interfaces;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import universalelectricity.api.vector.IVector3;
import universalelectricity.api.vector.IVectorWorld;
import universalelectricity.api.vector.Vector3;
import calclavia.api.IRotation;
import calclavia.lib.utility.nbt.ISaveObj;

/** *WIP* Interface applied to all sentry objects. Any sentry that uses this must have a constructor
 * that contains ISentryContainer parameter
 * 
 * @author DarkGaurdsman */
public interface ITurret extends ISaveObj, IVectorWorld, IRotation
{
    /** NBT string id that all sentries should use to identify themselves threw a NBTTagCompound save */
    public static final String SENTRY_TYPE_SAVE_ID = "sentryID";

    /** NBT string id that all sentries should save too in a TileEntity, ItemStack, or Entity. This
     * should contain the sentry id and other data used to recreate the sentry from a save */
    public static final String SENTRY_OBJECT_SAVE = "sentryTile";

    //Sentry traits constants *WIP*
    public static final String SEARCH_RANGE_TRAIT = "ai.search.range";
    public static final String HEALTH_TRAIT = "body.health";
    public static final String MAX_HEALTH_TRAIT = "body.health.max";
    public static final String ROTATION_SPEED_TRAIT = "body.rotation";
    public static final String ROTATION_SPEED_WITH_TARGET_TRAIT = "body.rotation.target";

    /** called each tick by the host to update the sentry */
    public void update();

    /** Gets the Tile or Entity that is hosting the sentry */
    public ITurretProvider getHost();

    /** Offset from the center offset to were the end of the barrel should be at */
    public Vector3 getAimOffset();

    /** Triggers the turret to fire at a location
     * 
     * @param target - IVector3 location, this can be a spot or an object
     * @return true if everything passed threw correctly */
    public boolean fire(IVector3 target);

    /** Triggers the turret to fire at an entity
     * 
     * @param target - Entity, does not imply living object
     * @return true if everything passed threw correctly */
    public boolean fire(Entity target);

    /** Map of upgrades and how much effect they have on the sentry */
    public HashMap<String, Double> upgrades();

    /** Gets the effective value of the upgrade type. This value is a percent bonus that is applied
     * to the sentry. */
    public double getUpgradeEffect(String upgrade);

    /** Map of main traits applied to the sentry */
    public HashMap<String, Double> traits();

    /** Gets the current value of the trait */
    public double getTrait(String trait);
}
