package de.metas.shipper.gateway.spi.model;

import java.time.LocalDate;
import java.util.Set;

import org.adempiere.util.Check;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

/*
 * #%L
 * de.metas.shipper.gateway.api
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Value
public class DeliveryOrderCreateRequest
{
	LocalDate pickupDate;
	Set<Integer> packageIds;
	int shipperTransportationId;

	String shipperGatewayId;

	@Builder
	public DeliveryOrderCreateRequest(
			@NonNull final LocalDate pickupDate,
			@NonNull @Singular final Set<Integer> packageIds,
			final int shipperTransportationId,
			@NonNull String shipperGatewayId)
	{
		this.pickupDate = pickupDate;
		this.packageIds = Check.assumeNotEmpty(packageIds, "packageIds is not empty");
		this.shipperTransportationId = shipperTransportationId;
		this.shipperGatewayId = shipperGatewayId;
	}
}
