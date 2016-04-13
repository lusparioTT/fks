package cn.timgise.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

@SuppressWarnings("rawtypes")
public class IpAddressInInterceptor extends AbstractPhaseInterceptor {

	public IpAddressInInterceptor() {
		super(Phase.RECEIVE);
	}

	@Override
	public void handleMessage(Message msg) throws Fault {
		// TODO Auto-generated method stub
		
	}
}
