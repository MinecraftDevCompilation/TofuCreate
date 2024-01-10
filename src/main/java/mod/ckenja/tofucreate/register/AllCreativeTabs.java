package mod.ckenja.tofucreate.register;

import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class AllCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TofuCreate.MODID);


    public static final RegistryObject<CreativeModeTab> TOFU_CREATE = CREATIVE_MODE_TABS.register("tofu_create", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + TofuCreate.MODID))
            .icon(() -> AllItems.TOFU_METAL_PLATE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(Stream.of(
                        AllItems.TOFU_METAL_PLATE,
                        AllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM,
                        AllItems.TOFU_PRECISION_MECHANISM
                ).map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());
            }).build());
}
