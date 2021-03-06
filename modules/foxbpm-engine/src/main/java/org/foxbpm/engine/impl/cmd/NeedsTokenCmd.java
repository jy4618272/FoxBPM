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
 * @author ych
 */
package org.foxbpm.engine.impl.cmd;

import java.io.Serializable;

import org.foxbpm.engine.impl.entity.TokenEntity;
import org.foxbpm.engine.impl.interceptor.Command;
import org.foxbpm.engine.impl.interceptor.CommandContext;
import org.foxbpm.engine.impl.util.ExceptionUtil;

public abstract class NeedsTokenCmd<T> implements Command<T>, Serializable {

	private static final long serialVersionUID = 1L;

	protected String tokenId;

	public NeedsTokenCmd(String tokenId) {
		this.tokenId = tokenId;
	}

	public T execute(CommandContext commandContext) {
		if (tokenId == null) {
			throw ExceptionUtil.getException("10601008");
		}
		TokenEntity token = commandContext.getTokenManager().findTokenById(tokenId);
		if (token == null) {
			throw ExceptionUtil.getException("10602002");
		}
		if (token.isSuspended()) {
			throw ExceptionUtil.getException("10603001");
		}
		return execute(commandContext, token);
	}

	protected abstract T execute(CommandContext commandContext, TokenEntity token);
}
