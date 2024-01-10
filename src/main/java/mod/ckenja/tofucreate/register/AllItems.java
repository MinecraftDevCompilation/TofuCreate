package mod.ckenja.tofucreate.register;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TofuCreate.MODID);

    public static final RegistryObject<Item> TOFU_METAL_PLATE = ITEMS.register("tofumetal_plate", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> TOFU_PRECISION_MECHANISM = ITEMS.register("tofu_precision_mechanism", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> INCOMPLETE_TOFU_PRECISION_MECHANISM = ITEMS.register("incomplete_tofu_precision_mechanism", () -> new Item((new Item.Properties())));
}

