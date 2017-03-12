package net.evenh.versionmonitor.application.notifications;

import net.evenh.versionmonitor.application.subscriptions.AbstractSubscription;
import net.evenh.versionmonitor.domain.releases.Release;

/**
 * An interface for notifying subscribers of new releases.
 *
 * @author Even Holthe
 * @since 2016-02-03
 */
public interface NotificationService {
  boolean sendNotification(Release release, AbstractSubscription subscription);
}