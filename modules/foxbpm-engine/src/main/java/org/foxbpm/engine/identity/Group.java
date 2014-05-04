/**
 * Copyright 1996-2014 FoxBPM ORG.
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
 * 
 * @author kenshin
 */
package org.foxbpm.engine.identity;

import java.util.Map;

/**
 * 组,用于组的数据传递
 * @author kenshin
 *
 */
public interface Group {
	
	public String getGroupId();

	public String getGroupType();
	
	public String getGroupName();

	public Map<String, Object> getPropertyMap();
	
	public Object getPropertyValue(String propertyName);
	
}