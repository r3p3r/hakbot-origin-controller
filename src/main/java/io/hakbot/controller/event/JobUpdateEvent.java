/*
 * This file is part of Hakbot Origin Controller.
 *
 * Hakbot Origin Controller is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Hakbot Origin Controller is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Hakbot Origin Controller. If not, see http://www.gnu.org/licenses/.
 */
package io.hakbot.controller.event;

import alpine.event.framework.UnblockedEvent;
import io.hakbot.controller.workers.State;

/**
 * This event is called when updates to the Job object are required during
 * job execution. This event handles the updating of state, processing
 * messages, and results.
 *
 * @see io.hakbot.controller.workers.JobUpdateLogger
 */
public class JobUpdateEvent extends BaseJobEvent implements UnblockedEvent {

    private String[] messages;
    private State state;
    private String result;

    public JobUpdateEvent(String jobUuid) {
        super(jobUuid);
    }

    public String[] getMessages() {
        return messages;
    }

    public State getState() {
        return state;
    }

    public String getResult() {
        return result;
    }

    public JobUpdateEvent message(String... messages) {
        this.messages = messages;
        return this;
    }

    public JobUpdateEvent state(State state) {
        this.state = state;
        return this;
    }

    public JobUpdateEvent result(String result) {
        this.result = result;
        return this;
    }

}
