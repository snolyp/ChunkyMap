package de.lemaik.chunkymap.rendering.local;

import de.lemaik.chunky.denoiser.BetterRenderManager;
import se.llbit.chunky.renderer.DefaultRenderManager;
import se.llbit.chunky.renderer.RenderContext;
import se.llbit.chunky.renderer.Renderer;
import se.llbit.chunky.renderer.ResetReason;

import java.util.function.BooleanSupplier;

public class BetterRenderManagerAdapter implements Renderer {
    private final BetterRenderManager betterRenderManager;

    public BetterRenderManagerAdapter(RenderContext context, boolean headless) {
        this.betterRenderManager = new BetterRenderManager(context, headless);
    }

    @Override
    public void render(DefaultRenderManager defaultRenderManager) throws InterruptedException {
        // BetterRenderManagerAdapter is a wrapper around BetterRenderManager
        // so we can delegate the render call to the wrapped instance
        betterRenderManager.start();
    }

    @Override
    public void sceneReset(DefaultRenderManager manager, ResetReason reason, int resetCount) {
        Renderer.super.sceneReset(manager, reason, resetCount);
    }

    @Override
    public boolean autoPostProcess() {
        return Renderer.super.autoPostProcess();
    }

    @Override
    public String getId() {
        long ID_long = betterRenderManager.getId();
        return Long.toString(ID_long);

    }

    @Override
    public String getName() {
        return betterRenderManager.getName();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setPostRender(BooleanSupplier booleanSupplier) {

    }

    // Implement other methods from the Renderer interface as needed
}