package uk.co.samuelwall.materialtaptargetprompt.extras;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

/**
 * Creates a sequence of prompts
 */
public class PromptSequence
{

    public static final String TAG = PromptSequence.class.getSimpleName();

    /**
     * The queue of prompts to be shown
     */
    private Queue<MaterialTapTargetPrompt.Builder> promptList;

    public PromptSequence(LinkedList<MaterialTapTargetPrompt.Builder> promptList)
    {
        this.promptList = this.promptList;
    }

    /**
     * Start the sequence
     */
    public void start()
    {

        Log.e(TAG, "TapTargetPrompt Sequence: queue is " + promptList);

        final MaterialTapTargetPrompt.Builder prompt = promptList.poll();

        if (prompt != null)
        {
            prompt.setPromptNextListener(new MaterialTapTargetPrompt.PromptNextListener()
            {
                @Override
                public void onPromptNext()
                {
                    start();
                }
            });
            prompt.show();
        }
    }
}
