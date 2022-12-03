package bookingClient;


import com.interviewHub.slotBooking.InterviewSlot.bookingMessage;
import com.interviewHub.slotBooking.InterviewSlot.slotDetails;
import com.interviewHub.slotBooking.slotBookingGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class slotBookingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost", 9080)
				.usePlaintext()
				.build();
		
		slotBookingGrpc.slotBookingBlockingStub stub=slotBookingGrpc.newBlockingStub(channel);
		bookingMessage response=stub.scheduleInterview(slotDetails.newBuilder().setInterviewerEmailId("interviewer@gmail.com").setIntervieweeEmailId("interviewee@gmail.com")
				.setTagTeamEmailId("tag@gmail.com").setDate("20/11/2022").setBoookingStatus("Active").setStartTime("10:00").setEndTime("11:00").setTechStack("Grpc").setDescription("SE Role").build()
				);
		
		
//		System.out.println(response.getBookingResponseMessage()+" "+response.getBookingResponseCode());
		System.out.println(response.getInterviewerEmailId()+" "+response.getIntervieweeEmailId()+" "+response.getTagTeamEmailId()
				+" "+ response.getDate()+" "+response.getBoookingStatus()+" "+response.getStartTime()+" "+response.getEndTime()
				+" "+ response.getTechStack()+" "+response.getDescription());
		
	}

}
