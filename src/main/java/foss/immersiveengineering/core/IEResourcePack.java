package foss.immersiveengineering.core;

import com.google.gson.JsonObject;
import foss.immersiveengineering.Tags;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.FMLContainerHolder;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SideOnly(Side.CLIENT)
public class IEResourcePack extends FolderResourcePack implements FMLContainerHolder {

    private final ModContainer container;

    public IEResourcePack(ModContainer container, String path) {
        super(new File(Launch.minecraftHome, path));
        this.container = container;
    }

    @Override
    public ModContainer getFMLContainer() {
        return this.container;
    }

    @Nonnull
    @Override
    public String getPackName() {
        return Tags.MOD_ID;
    }

    @Override
    public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer metadataSerializer, String metadataSectionName) throws IOException {
        JsonObject metadata = new JsonObject(), packObj = new JsonObject();
        metadata.add("pack", packObj);
        packObj.addProperty("description", "Immersive Engineering Assets");
        packObj.addProperty("pack_format", 2);
        return metadataSerializer.parseMetadataSection(metadataSectionName, metadata);
    }

    @Nonnull
    @Override
    public BufferedImage getPackImage() throws IOException {
        return super.getPackImage();
        // return TextureUtil.readBufferedImage(Objects.requireNonNull(IEResourcePack.class.getResourceAsStream("./logo.png")));
    }
}
