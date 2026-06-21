package com.exercise2;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Step 2: Call the method with specific arguments
        service.fetchData();

        // Step 3: Verify the interaction - verify that getData() was called
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyInteractionWithTimes() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        // Verify that getData() was called exactly once
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testVerifyNeverCalled() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Verify that getData() was never called
        verify(mockApi, never()).getData();
    }
}