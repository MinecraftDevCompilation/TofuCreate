package mod.ckenja.tofucreate.data;

import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.AllItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static mod.ckenja.tofucreate.TofuCreate.prefix;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, TofuCreate.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTex(AllItems.TOFU_METAL_PLATE);
        singleTex(AllItems.TOFU_PRECISION_MECHANISM);
        singleTex(AllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM);
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0)
            builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    private ItemModelBuilder singleTex(RegistryObject<?> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }
}
