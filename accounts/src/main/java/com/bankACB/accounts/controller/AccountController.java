package com.bankACB.accounts.controller;

import com.bankACB.accounts.constants.AccountsConstants;
import com.bankACB.accounts.dto.CustomerDto;
import com.bankACB.accounts.dto.ErrorResponseDto;
import com.bankACB.accounts.dto.ResponseDto;
import com.bankACB.accounts.services.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jason khongwir
 */
@Tag(
        name = "CRUD REST APIs for Accounts in Buckaroo",
        description = "CRUD REST APIs in Buckaroo to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService iAccountService;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer & Account inside Buckaroo"
    )
    @ApiResponses({
            @ApiResponse(responseCode = AccountsConstants.STATUS_201, description = AccountsConstants.MESSAGE_201, content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDTO) {
        iAccountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(AccountsConstants.STATUS_201)))
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account REST API",
            description = "REST API to fetch account details based on mobile number"
    )
    @ApiResponses({
            @ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200, content = @Content(schema = @Schema(implementation = CustomerDto.class))),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(
            @Parameter(description = "Mobile number of the customer") @RequestParam String mobileNumber) {
        CustomerDto customerDTO = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(AccountsConstants.STATUS_200))).body(customerDTO);
    }

    @Operation(
            summary = "Update Account REST API",
            description = "REST API to update customer account details"
    )
    @ApiResponses({
            @ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200, content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = AccountsConstants.STATUS_417, description = AccountsConstants.MESSAGE_417_UPDATE, content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDTO) {
        boolean isUpdated = iAccountService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(AccountsConstants.STATUS_200)))
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Account REST API",
            description = "REST API to delete customer account using mobile number"
    )
    @ApiResponses({
            @ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200, content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = AccountsConstants.STATUS_417, description = AccountsConstants.MESSAGE_417_DELETE, content = @Content(schema = @Schema(implementation = ResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid mobile number format", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(
            @Parameter(description = "Mobile number of the customer to delete account")
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(AccountsConstants.STATUS_200)))
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }
}
