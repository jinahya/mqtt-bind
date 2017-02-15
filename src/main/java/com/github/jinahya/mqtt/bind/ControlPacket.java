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
import static java.util.Objects.requireNonNull;

/**
 *
 * @author Jin Kwon &gt;onacit@gmail.com&lt;
 */
public abstract class ControlPacket implements Serializable {

    public enum Type {
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
        DISCONNECT(0x0E);

        // ---------------------------------------------------------------------
        public static Type valueOf(final int numericValue) {
            for (final Type value : ControlPacket.Type.values()) {
                if (value.numericValue == numericValue) {
                    return value;
                }
            }
            throw new IllegalArgumentException(
                "no constant mapped to " + numericValue);
        }

        // ---------------------------------------------------------------------
        private Type(final int numericValue) {
            this.numericValue = numericValue;
        }

        // -------------------------------------------------------- numericValue
        public int getNumericValue() {
            return numericValue;
        }

        // ---------------------------------------------------------------------
        private final int numericValue;
    }

    // -------------------------------------------------------------------------
    public ControlPacket(final Type type) {
        super();
        this.type = requireNonNull(type);
    }

    // -------------------------------------------------------------------- type
    public Type getType() {
        return type;
    }

    // -------------------------------------------------------------------------
    private final Type type;
}
