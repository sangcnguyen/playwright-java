package di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.microsoft.playwright.Page;
import factory.BrowserManager;
import factory.ChromeContext;

public class PageModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BrowserManager.class).to(ChromeContext.class).in(Scopes.SINGLETON);
    }

    @Provides
    public Page getPageInstance(BrowserManager browserManager){
        return browserManager.getPageInstance();
    }
}
