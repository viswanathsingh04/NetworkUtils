package com.pddstudio.networkutils.interfaces;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The generic interface used by all kind of services to deliver callback information.
 */
public interface ProcessCallback {

    /**
     * Gets invoked as soon as the requested service started.
     * @param serviceName - The name of the service which started.
     */
    void onProcessStarted(@NonNull final String serviceName);

    /**
     * Gets invoked in case the service failed to start or an error occurred during execution.
     * @param serviceName - The name of the service which failed
     * @param errorMessage - An additional error message what might be the reason for the issue.
     * @param errorCode - An additional error code, defined as {@linkplain Integer} value.
     */
    void onProcessFailed(@NonNull final String serviceName, @Nullable String errorMessage, int errorCode);

    /**
     * Gets invoked as soon as the requested service finished successfully.
     * @param serviceName - The name of the service which finished.
     * @param endMessage - An additional result message.
     */
    void onProcessFinished(@NonNull final String serviceName, @Nullable String endMessage);

    /**
     * Gets invoked as soon as the requested service cached some partial results.
     * The result is an instance of {@linkplain Object}, so it needs to be casted to match the service's return type.
     * @param processUpdate - The service's return type as an {@linkplain Object}
     */
    void onProcessUpdate(@NonNull Object processUpdate);
}
