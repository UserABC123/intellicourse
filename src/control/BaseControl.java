/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import model.user.User;

/**
 *
 * @author Raphael
 */
public class BaseControl
{
    private final CurriculumControl cc;
    private final UserControl uc;
    private final MainControl mc;
    private final CourseControl coc;
    private final AccountControl ac;
    
    public BaseControl()
    {
        cc = new CurriculumControl(this);
        uc = new UserControl(this);
        mc = new MainControl(this);
        coc = new CourseControl(this);
        ac = new AccountControl(this);
    }
    
    public static void main(String[] args)
    {
        (new BaseControl()).getUc().start();
    }

    public CurriculumControl getCc()
    {
        return cc;
    }

    public UserControl getUc()
    {
        return uc;
    }

    public MainControl getMc()
    {
        return mc;
    }

    public CourseControl getCoc()
    {
        return coc;
    }

    public AccountControl getAc()
    {
        return ac;
    }
    
    public User getLoggedInAs()
    {
        return uc.getLoggedInAs();
    }
}
