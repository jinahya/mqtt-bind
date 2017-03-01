/*
 * Copyright 2017 onacit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.mqtt.bind;

import java.io.Serializable;

public abstract class ControlPacket implements Serializable {

    public enum Spec {
        _RESERVED0(0x00),
        CONNECT(0x01),
        CONNACK(0x02),
        PUBLISH(0x03),
        PUBACK(0x04),
        PUBREC(0x05),
        PUBREL(0x06),
        PUBCOMP(0x07),
        SUBSCRIBE(0x08),
        SUBACK(0x09),
        UNSUBSCRIBE(0x0A),
        UNSUBACK(0x0B),
        PINGREQ(0x0C),
        PINGRESP(0x0D),
        DISCONNECT(0x0E),
        _RESERVEDF(0x0F);

        // ---------------------------------------------------------------------
        public static Spec valueOf(final int type) {
            for (final Spec value : values()) {
                if (value.type == type) {
                    return value;
                }
            }
            throw new IllegalArgumentException("no constant mapped to " + type);
        }

        // ---------------------------------------------------------------------
        private Spec(final int type) {
            this.type = type;
        }

        // ---------------------------------------------------------------- type
        public int getType() {
            return type;
        }

        // ---------------------------------------------------------------------
        private final int type;
    }

    // -------------------------------------------------------------------------
    public ControlPacket(final Spec spec) {
        super();
        if (spec == null) {
            throw new NullPointerException("null spec");
        }
        this.spec = spec;
    }

    // -------------------------------------------------------------------- spec
    public Spec getSpec() {
        return spec;
    }

    public int getType() {
        return spec.getType();
    }

    // -------------------------------------------------------------------------
    protected int getFlag() {
        return flag;
    }

    protected void setFlag(final int flag) {
        this.flag = flag;
    }

    // -------------------------------------------------------------------------
    protected final Spec spec;

    private int flag;
}
