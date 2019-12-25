package com.binance.client;

import com.binance.client.impl.BinanceApiInternalFactory;
import com.binance.client.model.CoinInformation;
import com.binance.client.model.DepositAddressSapi;
import com.binance.client.model.DepositHistory;
import com.binance.client.model.DepositHistorySapi;
import com.binance.client.model.SystemStatus;
import com.binance.client.model.TradeStatistics;
import com.binance.client.model.WithdrawHistory;
import com.binance.client.model.WithdrawHistorySapi;

import java.util.List;

/**
 * Synchronous request interface, invoking Huobi RestAPI via synchronous
 * method.<br>
 * All methods in this interface will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the
 * {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface SyncRequestClient {

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @return The instance of synchronous client.
     */
    static SyncRequestClient create() {
        return create("", "", new RequestOptions());
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static SyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createSyncRequestClient(apiKey, secretKey, new RequestOptions());
    }

    /**
     * Create the synchronous client. All interfaces defined in synchronous client
     * are implemented by synchronous mode.
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @param options   The request option.
     * @return The instance of synchronous client.
     */
    static SyncRequestClient create(String apiKey, String secretKey, RequestOptions options) {
        return BinanceApiInternalFactory.getInstance().createSyncRequestClient(apiKey, secretKey, options);
    }

    /**
     * Get trade statistics in 24 hours.
     *
     * @param symbol The symbol, like "btcusdt". (mandatory)
     * @return Trade statistics, see {@link TradeStatistics}
     */
    TradeStatistics get24HTradeStatistics(String symbol);

    /**
     * Fetch system status.
     *
     * @return System status.
     */
    SystemStatus getSystemStatus();

    /**
     * Get all coins' information for user.
     *
     * @return All coins' information.
     */
    List<CoinInformation> getAllCoinsInformation();

    /**
     * Submit a withdraw request.
     *
     * @return Transaction ID.
     */
    Long postWithdrawSapi(String coin, String address, String amount, String network, String addressTag, String name);

    /**
     * Submit a withdraw request.
     *
     * @return Transaction ID.
     */
    Long postWithdraw(String asset, String address, String amount, String network, String addressTag, String name);

    /**
     * Fetch deposit history.
     *
     * @return Deposit history.
     */
    List<DepositHistorySapi> getDepositHistorySapi(String coin, Integer status, Long startTime, Long endTime, Integer offset);

    /**
     * Fetch deposit history.
     *
     * @return Deposit history.
     */
    List<DepositHistory> getDepositHistory(String asset, Integer status, Long startTime, Long endTime);

    /**
     * Fetch withdraw history.
     *
     * @return Withdraw history.
     */
    List<WithdrawHistorySapi> getWithdrawHistorySapi(String coin, Integer status, Integer offset, 
            Integer limit, Long startTime, Long endTime);

    /**
     * Fetch withdraw history.
     *
     * @return Withdraw history.
     */
    List<WithdrawHistory> getWithdrawHistory(String asset, Integer status, Long startTime, Long endTime);

    /**
     * Fetch deposit address with network.
     *
     * @return Deposit address.
     */
    DepositAddressSapi getDepositAddressSapi(String coin, String network);

}
