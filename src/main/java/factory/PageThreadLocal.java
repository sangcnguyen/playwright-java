package factory;

import com.microsoft.playwright.Page;

public class PageThreadLocal {
    private static final ThreadLocal<Page> pageTL = new ThreadLocal<>();

    private PageThreadLocal() {
    }

    public static Page getPage() {
        return pageTL.get();
    }

    public static void setPage(Page page) {
        PageThreadLocal.pageTL.set(page);
    }

    public static void closePage() {
        PageThreadLocal.pageTL.get().close();
        pageTL.remove();
    }
}
