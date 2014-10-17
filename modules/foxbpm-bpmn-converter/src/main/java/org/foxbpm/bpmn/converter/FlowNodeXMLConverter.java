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
 * @author yangguangftlp
 */
package org.foxbpm.bpmn.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.foxbpm.bpmn.constants.BpmnXMLConstants;
import org.foxbpm.model.BaseElement;
import org.foxbpm.model.FlowElement;
import org.foxbpm.model.FlowNode;


/**
 * 常量类
 * 
 * @author yangguangftlp
 * @date 2014年10月15日
 */
public abstract class FlowNodeXMLConverter extends FlowElementXMLConverter {

	public FlowElement cretateFlowElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends BaseElement> getBpmnElementType() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public void convertXMLToModel(Element element, BaseElement baseElement) {
		FlowNode flowNode =(FlowNode)baseElement;
		
		Iterator<Element> elementIterator = element.elements().iterator();
		Element subElement = null;
		Element extentionElement = null;
		while(elementIterator.hasNext()){
			subElement = elementIterator.next();
			if(BpmnXMLConstants.ELEMENT_EXTENSION_ELEMENTS.equals(subElement.getName())){
				Iterator<Element> extentionIterator = subElement.elements().iterator();
				while(extentionIterator.hasNext()){
					extentionElement = extentionIterator.next();
					 if(BpmnXMLConstants.ELEMENT_INCOMING.equals(extentionElement.getName())){
						List<String> incomingFlows = flowNode.getIncomingFlows();
						if(incomingFlows == null){
							incomingFlows = new ArrayList<String>();
							flowNode.setIncomingFlows(incomingFlows);
						} 
						incomingFlows.add(extentionElement.getText());
					}else if(BpmnXMLConstants.ELEMENT_OUTGOING.equals(extentionElement.getName())){
						List<String> outgoingFlows = flowNode.getOutgoingFlows();
						if(outgoingFlows == null){
							outgoingFlows = new ArrayList<String>();
							flowNode.setOutgoingFlows(outgoingFlows);
						}
						
						outgoingFlows.add(extentionElement.getText());
					} 
					

				}
			}
		}
	}

	@Override
	public void convertModelToXML(Element element, BaseElement baseElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getXMLElementName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
