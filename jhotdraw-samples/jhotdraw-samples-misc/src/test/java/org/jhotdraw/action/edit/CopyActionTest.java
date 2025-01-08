package org.jhotdraw.action.edit;

import org.jhotdraw.datatransfer.ClipboardUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;

public class CopyActionTest {

    private CopyAction copyAction;
    private JTextComponent mockComponent;
    private Clipboard mockClipboard;
    private KeyboardFocusManager mockFocusManager;

    @BeforeEach
    public void setUp(){
        mockComponent = mock(JTextComponent.class);

        mockClipboard = mock(Clipboard.class);

        ClipboardUtil.setClipboard(mockClipboard);

        copyAction = new CopyAction(mockComponent);

        mockFocusManager = mock(KeyboardFocusManager.class);
        KeyboardFocusManager.setCurrentKeyboardFocusManager(mockFocusManager);
    }

    @Test
    public void testActionPerformed_withTargetComponent() {
        // Create a mock ActionEvent
        ActionEvent event = mock(ActionEvent.class);

        // Call actionPerformed with the target component explicitly set
        copyAction.actionPerformed(event);

        // Verify that exportToClipboard was called on the TransferHandler of the target component
        verify(mockComponent.getTransferHandler(), times(1))
                .exportToClipboard(mockComponent, mockClipboard, TransferHandler.COPY);
    }

    @Test
    public void testActionPerformed_withFocusedComponent() {
        // Create a mock JComponent and set it as the focus owner
        when(mockFocusManager.getPermanentFocusOwner()).thenReturn(mockComponent);

        // Create a new CopyAction with no target (should use focused component)
        copyAction = new CopyAction(null);

        // Create a mock ActionEvent and call actionPerformed
        ActionEvent event = mock(ActionEvent.class);
        copyAction.actionPerformed(event);

        // Verify that exportToClipboard was called on the TransferHandler of the focused component
        verify(mockComponent.getTransferHandler(), times(1))
                .exportToClipboard(mockComponent, mockClipboard, TransferHandler.COPY);
    }

    @Test
    public void testActionPerformed_noTargetOrFocus() {
        // Set no focus owner
        when(mockFocusManager.getPermanentFocusOwner()).thenReturn(null);

        // Create a new CopyAction with no target
        copyAction = new CopyAction(null);

        // Create a mock ActionEvent and call actionPerformed
        ActionEvent event = mock(ActionEvent.class);
        copyAction.actionPerformed(event);

        // Verify that exportToClipboard was not called
        verify(mockComponent.getTransferHandler(), times(0))
                .exportToClipboard(mockComponent, mockClipboard, TransferHandler.COPY);
    }
}