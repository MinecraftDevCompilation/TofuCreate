package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.PackOutput;

import java.util.function.UnaryOperator;

public class ModSequencedAssemblyRecipeGen extends CreateRecipeProvider {

    GeneratedRecipe

            PRECISION_MECHANISM = create("tofu_precision_mechanism", b -> b.require(mod.ckenja.tofucreate.register.AllItems.TOFU_METAL_PLATE.get())
            .transitionTo(mod.ckenja.tofucreate.register.AllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM.get())
            .addOutput(mod.ckenja.tofucreate.register.AllItems.TOFU_PRECISION_MECHANISM.get(), 120)
            .addOutput(mod.ckenja.tofucreate.register.AllItems.TOFU_METAL_PLATE.get(), 8)
            .addOutput(AllBlocks.COGWHEEL.get(), 2)
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(TofuItems.TOFUGEM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllBlocks.COGWHEEL))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllBlocks.COGWHEEL)));

    public ModSequencedAssemblyRecipeGen(PackOutput p_i48262_1_) {
        super(p_i48262_1_);
    }

    protected GeneratedRecipe create(String name, UnaryOperator<SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SequencedAssemblyRecipeBuilder(Create.asResource(name)))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

}