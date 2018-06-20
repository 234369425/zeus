package com.beheresoft.security.configure;

import io.buji.pac4j.profile.ShiroProfileManager;
import org.pac4j.cas.logout.DefaultCasLogoutHandler;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.context.session.SessionStore;
import org.springframework.stereotype.Component;

/**
 * @author Aladi
 */
@Component
public class CasLogoutHandler extends DefaultCasLogoutHandler {

    @Override
    protected void destroy(WebContext context, SessionStore sessionStore, String channel) {
        final ShiroProfileManager manager = new ShiroProfileManager(context);
        manager.logout();
        logger.debug("destroy the user profiles");
        // and optionally the web session
        if (isDestroySession()) {
            logger.debug("destroy the whole session");
            final boolean invalidated = sessionStore.destroySession(context);
            if (!invalidated) {
                logger.error("The session has not been invalidated for {} channel logout", channel);
            }
        }
    }
}
