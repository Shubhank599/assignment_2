package com.cg.mts.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.AdminNotFoundException;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.CustomerNotFoundException;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	// public Admin insertAdmin(Admin admin);
	//
	// public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	//
	// public Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	@Query(value ="select from trb from TripBooking trb where trb.customerId=:customerId" )
	 public List<TripBooking> getAllTrips(@Param("customerId")int customerId) throws
	 CustomerNotFoundException;
	
	@Query(value = "SELECT tr FROM TripBooking tr where tr.driver.driverId in(select dr.driverId from Driver dr where dr.cab.cabId in (select c.cabId from Cab c group by c.cabId))")
	public List<TripBooking> getTripsCabwise() 
	throws CabNotFoundException;

	@Query(value = "SELECT tr from TripBooking tr group by tr.customerId")
	public List<TripBooking> getTripsCustomerwise();
	
	@Query(value = "select tr from TripBooking tr group by tr.fromDateTime")
	public List<TripBooking> getTripsDatewise();
	
	@Query(value = "select e from TripBooking e where e.customerId = :customerId and e.fromDateTime = :fromdatetime and e.toDateTime = :todatetime", name = "find tripbooking by multiple")
	public List<TripBooking> getAllTripsForDays(@Param("customerId") int customerId, @Param("LocalDateTime") LocalDateTime fromDate,@Param("LocalDateTime") LocalDateTime toDate) throws 
	CustomerNotFoundException;
	

}