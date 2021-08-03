package module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.microsoft.playwright.Page;
import factory.PageThreadLocal;

public class PageModule extends AbstractModule {

    @Provides
    public Page getPageInstance(){
        return PageThreadLocal.getPage();
    }
}
