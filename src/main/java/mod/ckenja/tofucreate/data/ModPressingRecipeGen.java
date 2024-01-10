package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.register.AllItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ModPressingRecipeGen extends ProcessingRecipeGen {

    GeneratedRecipe TOFU_METAL = create(new ResourceLocation(TofuCreate.MODID, "tofu_metal"), b -> b.require(TofuItems.TOFUMETAL.get())
            .output(AllItems.TOFU_METAL_PLATE.get()));

    public ModPressingRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.PRESSING;
    }

}