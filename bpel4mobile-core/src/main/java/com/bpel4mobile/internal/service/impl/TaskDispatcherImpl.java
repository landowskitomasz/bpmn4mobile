package com.bpel4mobile.internal.service.impl;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpel4mobile.internal.definition.TaskDefinition;
import com.bpel4mobile.internal.model.Task;
import com.bpel4mobile.internal.service.DefinitionProvider;
import com.bpel4mobile.internal.service.TaskDispatcher;
import com.bpel4mobile.internal.service.TaskRepository;
import com.google.common.base.Preconditions;

@Service
public class TaskDispatcherImpl implements TaskDispatcher {

	private static Logger LOG = Logger.getLogger(TaskDispatcherImpl.class);

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private DefinitionProvider definitionProvider;
	
	@Override
	public <T, R> String createNewTask(String taskName, String callbackUrl, T request, Class<R> resultType) {

		TaskDefinition definition = definitionProvider.getTaskDefinition(taskName);
		Preconditions.checkNotNull(definition, "Can't find task definition.");
		
		String uuid = UUID.randomUUID().toString();
		
		Task<T,R> task = new Task<T, R>();
		task.setUuid(uuid);
		task.setName(taskName);
		task.setCallbackUrl(callbackUrl);
		task.setCreateDate(new Date());
		task.setPriority(resolvePriority(definition.getPriority(), request));
		task.setRequest(request);
		task.setResult(tryToCreateInstance(resultType));
		
		return uuid;
	}
	
	private <R> R tryToCreateInstance(Class<R> resultType){
		try{
			Constructor<R> constructor = resultType.getConstructor();
			return constructor.newInstance();
		} catch (Exception e){
			LOG.error("Can't create instance of result class. This is realy fatal. "
						+ "Make sure class have default no argument constructor.");
		}
		
		return null;
	}
	
	private <T> int resolvePriority(String expression, T request){
		if(expression != null){
			if(expression.startsWith("exp:")){
				
			}
			else {
				try{
					return Integer.parseInt(expression.trim());
				} catch(NumberFormatException e){
					LOG.error("Priority expression not containt exp: prefix, so it shoud be integer type."
								+" Thare was a problem when trying to parse it.");
				}
			}
		}
		return 5;
	}

}
