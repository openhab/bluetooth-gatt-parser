package org.openhab.bluetooth.gattparser.spec;

/*-
 * Copyright (C) 2017 Sputnik Dev
 * %%
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
 * #L%
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.math.BigInteger;

/**
 *
 * @author Vlad Kolotov
 */
@XStreamAlias("Bit")
public class Bit {

    @XStreamAsAttribute
    private int index;
    @XStreamAsAttribute
    private int size;
    @XStreamAsAttribute
    private String name;
    @XStreamAlias("Enumerations")
    private Enumerations enumerations;

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Enumerations getEnumerations() {
        return enumerations;
    }

    public String getFlag(byte value) {
        if (enumerations == null) {
            return null;
        }
        for (Enumeration enumeration : enumerations.getEnumerations()) {
            if (enumeration.getKey().equals(BigInteger.valueOf(value))) {
                return enumeration.getRequires();
            }
        }
        return null;
    }
}