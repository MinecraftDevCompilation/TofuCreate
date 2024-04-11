package mod.ckenja.tofucreate.data;

import baguchan.tofucraft.registry.TofuItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.function.UnaryOperator;

public class ModSequencedAssemblyRecipeGen extends CreateRecipeProvider {

    GeneratedRecipe

            PRECISION_MECHANISM = create("tofu_precision_mechanism", b -> b.require(mod.ckenja.tofucreate.register.AllItems.TOFU_METAL_PLATE.get())
            .transitionTo(mod.ckenja.tofucreate.register.AllItems.INCOMPLETE_TOFU_PRECISION_MECHANISM.get())
            .addOutput(mod.ckenja.tofucreate.register.AllItems.TOFU_PRECISION_MECHANISM.get(), 120)
            .addOutput(mod.ckenja.tofucreate.register.AllItems.TOFU_METAL_PLATE.get(), 8)
            .addOutput(Items.REDSTONE, 2)
            .loops(2)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(TofuItems.TOFUGEM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(mod.ckenja.tofucreate.register.AllItems.TF_COMPACT_CIRCUIT.get())));

    GeneratedRecipe

            TF_COMPACT_CIRCUIT = create("tf_compact_circuit", b -> b.require(TofuItems.TOFUISHI.get())
            .transitionTo(mod.ckenja.tofucreate.register.AllItems.INCOMPLETE_TF_COMPACT_CIRCUIT.get())
            .addOutput(mod.ckenja.tofucreate.register.AllItems.TF_COMPACT_CIRCUIT.get(), 120)
            .addOutput(TofuItems.TOFUISHI.get(), 5)
            .addOutput(Items.REDSTONE, 5)
            .loops(1)
            .addStep(PressingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE)));


    public ModSequencedAssemblyRecipeGen(PackOutput p_i48262_1_) {
        super(p_i48262_1_);
    }

    protected GeneratedRecipe create(String name, UnaryOperator<SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SequencedAssemblyRecipeBuilder(TofuCreate.prefix(name)))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

}